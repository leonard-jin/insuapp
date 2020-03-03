package com.therich.apps.usecase.login;

import com.therich.apps.dataproviders.persistences.members.entities.Account;
import com.therich.apps.dataproviders.persistences.members.entities.Member;

/**
 * Created by kh.jin on 2020. 3. 2.
 */
public interface LoginPersistence {
    Account findAccount(String email);
    Member findMember(String email);
}

