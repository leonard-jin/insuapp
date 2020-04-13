package com.therich.apps.usecase.members;

import com.therich.apps.dataproviders.members.persistence.entity.Account;
import com.therich.apps.dataproviders.members.persistence.entity.Member;

/**
 * Created by kh.jin on 2020. 2. 25.
 */
public interface MemberRegisterDataProvider {

    boolean hasEmail(String email);
    boolean canRegisterRecommendEmail(String email);
    void registerMember(Member member);
    void registerAccount(Account account);
}
