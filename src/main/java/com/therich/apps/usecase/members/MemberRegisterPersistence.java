package com.therich.apps.usecase.members;

import com.therich.apps.dataproviders.persistences.members.entities.Account;
import com.therich.apps.dataproviders.persistences.members.entities.Member;

/**
 * Created by kh.jin on 2020. 2. 25.
 */
public interface MemberRegisterPersistence {

    boolean hasEmail(String email);
    boolean canRegisterRecommendEmail(String email);
    void registerMember(Member member);
    void registerAccount(Account account);
}
