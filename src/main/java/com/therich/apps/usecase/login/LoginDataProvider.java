package com.therich.apps.usecase.login;

import com.therich.apps.dataproviders.members.persistence.entity.Account;

/**
 * Created by kh.jin on 2020. 3. 2.
 */
public interface LoginDataProvider {
    Account findAccount(String email);
}

