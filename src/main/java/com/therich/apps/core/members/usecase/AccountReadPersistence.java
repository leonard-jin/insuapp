package com.therich.apps.core.members.usecase;

import com.therich.apps.core.members.persistences.entities.Account;

/**
 * Created by kh.jin on 2020. 2. 26.
 */
public interface AccountReadPersistence {
    Account findId(String email);
}
