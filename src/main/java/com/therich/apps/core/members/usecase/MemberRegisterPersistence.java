package com.therich.apps.core.members.usecase;

import com.therich.apps.core.members.persistences.entities.Account;
import com.therich.apps.core.members.persistences.entities.Member;

/**
 * Created by kh.jin on 2020. 2. 25.
 */
public interface MemberRegisterPersistence {

    boolean hasEmail(String email);
    boolean canRegisterRecommendEmail(String email);
    void registerMember(Member member);
    void registerAccount(Account account);
}
