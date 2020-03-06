package com.therich.apps.dataproviders;

import com.therich.apps.dataproviders.persistences.members.entities.Member;
import com.therich.apps.dataproviders.persistences.members.repositories.MemberJpaRepository;
import com.therich.apps.dataproviders.persistences.recommend.entities.Recommend;
import com.therich.apps.dataproviders.persistences.recommend.repositories.RecommendJpaRepository;
import com.therich.apps.usecase.recommend.RecommendRegisterPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2020. 3. 5.
 */
@Component
public class RecommendRegisterPersistenceImpl implements RecommendRegisterPersistence {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final MemberJpaRepository memberJpaRepository;
    private final RecommendJpaRepository recommendJpaRepository;

    public RecommendRegisterPersistenceImpl(MemberJpaRepository memberJpaRepository,
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
        return recommendJpaRepository.countById_ParentMemberNo(parentMemberNo);
    }

    @Override
    public void registerRecommend(Recommend recommend) {
        recommendJpaRepository.save(recommend);
    }
}
