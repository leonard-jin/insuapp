package com.therich.apps.dataproviders;

import com.therich.apps.dataproviders.members.persistence.entity.Account;
import com.therich.apps.dataproviders.members.persistence.repository.AccountJpaRepository;
import com.therich.apps.usecase.login.LoginDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2020. 3. 2.
 */
@Component
public class LoginDataProviderImpl implements LoginDataProvider {
    private final AccountJpaRepository accountJpaRepository;

    @Autowired
    public LoginDataProviderImpl(AccountJpaRepository accountJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public Account findAccount(String email) {
        return accountJpaRepository.getOne(email);
    }
}
