package com.therich.apps.usecase.recommend;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.therich.apps.dataproviders.persistences.members.entities.Member;
import com.therich.apps.dataproviders.persistences.recommend.entities.Recommend;
import com.therich.apps.globals.exceptions.BusinessException;
import com.therich.apps.globals.exceptions.codes.BusinessErrorCode;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Email;

/**
 * Created by kh.jin on 2020. 3. 5.
 */
@Transactional
@Service
public class RecommendRegisterUseCase {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final RecommendRegisterPersistence persistence;

    public RecommendRegisterUseCase(RecommendRegisterPersistence persistence) {
        this.persistence = persistence;
    }

    public void register(Command command) {
        Member recommendMember = persistence.findMember(command.recommendEmail);
        if (recommendMember == null) {
            log.error("[RECOMMEND] not found. recommend member. email : {}", command.recommendEmail);
            throw new BusinessException(BusinessErrorCode.NO_DATA);
        }

        Integer count = persistence.countRecommend(recommendMember.getMemberNo());
        if (count > 1) {
            log.error("[RECOMMEND] Don't added. child member : {}", count);
            throw new BusinessException(BusinessErrorCode.INVALID);
        }

        Recommend recommend = new Recommend(
                Recommend.PK.builder()
                        .memberNo(command.memberNo)
                        .parentMemberNo(recommendMember.getMemberNo())
                        .build(), count);

        persistence.registerRecommend(recommend);
        log.debug("[RECOMMEND] completed register.");
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    @EqualsAndHashCode(callSuper = false)
    public static class Command {
        @JsonProperty("member_no")
        private Long memberNo;

        @JsonProperty("recommend_email")
        @Email
        private String recommendEmail;
    }
}
