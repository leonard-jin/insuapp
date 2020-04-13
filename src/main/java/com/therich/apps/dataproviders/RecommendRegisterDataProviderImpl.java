package com.therich.apps.dataproviders;

import com.therich.apps.dataproviders.members.persistence.entity.Member;
import com.therich.apps.dataproviders.members.persistence.repository.MemberJpaRepository;
import com.therich.apps.dataproviders.recommends.persistence.entity.Recommend;
import com.therich.apps.dataproviders.recommends.persistence.repository.RecommendJpaRepository;
import com.therich.apps.usecase.recommend.RecommendRegisterDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2020. 3. 5.
 */
@Component
public class RecommendRegisterDataProviderImpl implements RecommendRegisterDataProvider {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final MemberJpaRepository memberJpaRepository;
    private final RecommendJpaRepository recommendJpaRepository;

    public RecommendRegisterDataProviderImpl(MemberJpaRepository memberJpaRepository,
                                             RecommendJpaRepository recommendJpaRepository) {
        this.memberJpaRepository = memberJpaRepository;
        this.recommendJpaRepository = recommendJpaRepository;
    }

    @Override
    public Member findMember(String email) {
        return memberJpaRepository.findByEmail(email);
    }

    @Override
    public Integer countRecommend(Long parentMemberNo) {
        return recommendJpaRepository.countByParentMemberNo(parentMemberNo);
    }

    @Override
    public void registerRecommend(Recommend recommend) {
        recommendJpaRepository.save(recommend);
    }
}
