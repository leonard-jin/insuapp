package com.therich.apps.usecase.members;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.therich.apps.dataproviders.codes.RoleCode;
import com.therich.apps.dataproviders.persistences.members.entities.Account;
import com.therich.apps.dataproviders.persistences.members.entities.Member;
import com.therich.apps.globals.exceptions.AppsException;
import com.therich.apps.globals.exceptions.BusinessException;
import com.therich.apps.globals.exceptions.codes.BusinessErrorCode;
import com.therich.apps.globals.services.encrypt.SHA256EncoderHelper;
import com.therich.apps.globals.services.encrypt.SaltGenerator;
import com.therich.apps.globals.validators.SecretSocialId;
import com.therich.apps.usecase.recommend.RecommendRegisterUseCase;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

/**
 * Created by kh.jin on 2020. 2. 15.
 */
@Service
public class MemberRegisterUseCase {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ApplicationEventPublisher publisher;
    private final MemberRegisterPersistence persistence;
    private final static String ERR_DUPLICATE_EMAIL_MSG = "이미 등록된 Email 입니다..";

    @Autowired
    public MemberRegisterUseCase(ApplicationEventPublisher publisher,
                                 MemberRegisterPersistence persistence) {
        this.publisher = publisher;
        this.persistence = persistence;
    }

    @Transactional
    public void join(Command command) {
        if (persistence.hasEmail(command.email)) {
            log.error("[business handle] {} is Already exist. ", command.email);
            throw new BusinessException(BusinessErrorCode.CONFLICT, this.ERR_DUPLICATE_EMAIL_MSG);
        }

        Member member = mappingToMember(command);
        persistence.registerMember(member);

        try {
            persistence.registerAccount(mappingToAccount(command));
        } catch (NoSuchAlgorithmException e) {
            log.error("....");
            throw new AppsException();
        }

        publisher.publishEvent(RecommendRegisterUseCase
                .Command
                .builder()
                .memberNo(member.getMemberNo())
                .recommendEmail(command.recommendMemberId)
                .build());
    }

    private Member mappingToMember(Command command) {
        return Member.builder()
                .email(command.email)
                .name(command.name)
                .mobile(command.mobile)
                .address(command.address)
                .socialId(command.socialId)
                .build();
    }

    private Account mappingToAccount(Command command) throws NoSuchAlgorithmException {
        String salt = SaltGenerator.generate();
        return Account.builder()
                .email(command.email)
                .password(SHA256EncoderHelper.getInstance().encypt(command.password, salt))
                .salt(salt)
                .loginFailedCount(0)
                .lastLoginDate(LocalDateTime.now())
                .pwChangedDate(LocalDateTime.now())
                .role(RoleCode.ROLE_OWNER)
                .level(-1)
                .build();
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    @EqualsAndHashCode(callSuper = false)
    public static class Command {

        @JsonProperty("email")
        @Email
        private String email;

        @JsonProperty("password")
        @NotBlank
        private String password;

        @JsonProperty("name")
        @NotBlank
        private String name;

        @JsonProperty("social_id")
        @SecretSocialId
        private String socialId;

        @JsonProperty("mobile")
        private String mobile;

        @JsonProperty("address")
        private String address;

        @JsonProperty("recommend_member_id")
        @Email
        private String recommendMemberId;
    }
}


