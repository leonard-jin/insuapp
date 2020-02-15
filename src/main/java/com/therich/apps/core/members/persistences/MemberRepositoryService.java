package com.therich.apps.core.members.persistences;

import com.therich.apps.core.members.persistences.entities.Account;
import com.therich.apps.core.members.persistences.entities.Auth;
import com.therich.apps.core.members.persistences.entities.Member;

/**
 * Created by kh.jin on 2020. 2. 15.
 */
public interface MemberRepositoryService {

    boolean hasMemberBySocialSecretId(String socialSecretId);

    void createMember(Member member);

    void createAccount(Account account);

    void createAuth(Auth auth);
}
