package com.therich.apps.usecase.members;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.therich.apps.dataproviders.members.persistence.entity.Account;
import com.therich.apps.dataproviders.members.persistence.entity.Member;
import com.therich.apps.globals.exceptions.BusinessException;
import com.therich.apps.globals.exceptions.codes.BusinessErrorCode;
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

/**
 * Created by kh.jin on 2020. 2. 15.
 */
@Service
public class MemberRegisterUseCase {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ApplicationEventPublisher publisher;
    private final MemberRegisterDataProvider dataProvider;
    private final static String ERR_DUPLICATE_EMAIL_MSG = "이미 등록된 Email 입니다..";

    @Autowired
    public MemberRegisterUseCase(ApplicationEventPublisher publisher,
                                 MemberRegisterDataProvider dataProvider) {
        this.publisher = publisher;
        this.dataProvider = dataProvider;
    }

    @Transactional
    public void join(Command command) throws NoSuchAlgorithmException {
        if (dataProvider.hasEmail(command.email)) {
            log.error("[business handle] {} is Already exist. ", command.email);
            throw new BusinessException(BusinessErrorCode.CONFLICT, this.ERR_DUPLICATE_EMAIL_MSG);
        }

        Member member = new Member(command);
        log.debug("Join member : {}", member);
        dataProvider.registerMember(member);

        Account account = new Account(command);
        log.debug("Join account : {}", account);
        dataProvider.registerAccount(account);

        publisher.publishEvent(RecommendRegisterUseCase.Command
                .builder()
                .memberNo(member.getMemberNo())
                .recommendEmail(command.recommendMemberId)
                .build());

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
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