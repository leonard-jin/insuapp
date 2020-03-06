package com.therich.apps.usecase.recommend;

import com.therich.apps.dataproviders.persistences.members.entities.Member;
import com.therich.apps.dataproviders.persistences.recommend.entities.Recommend;

/**
 * Created by kh.jin on 2020. 3. 5.
 */
public interface RecommendRegisterPersistence {

    Member findMember(String email);
    Integer countRecommend(Long parentMemberNo);
    void registerRecommend(Recommend recommend);
}

