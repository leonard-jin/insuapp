package com.therich.apps.usecase.recommend;

import com.therich.apps.dataproviders.members.persistence.entity.Member;
import com.therich.apps.dataproviders.recommends.persistence.entity.Recommend;

/**
 * Created by kh.jin on 2020. 3. 5.
 */
public interface RecommendRegisterDataProvider {

    Member findMember(String email);
    Integer countRecommend(Long parentMemberNo);
    void registerRecommend(Recommend recommend);
}

