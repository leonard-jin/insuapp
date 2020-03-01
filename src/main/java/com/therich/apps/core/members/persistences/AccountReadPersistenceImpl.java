package com.therich.apps.core.members.persistences;

import com.therich.apps.core.members.persistences.entities.Account;
import com.therich.apps.core.members.persistences.repositories.AccountJpaRepository;
import com.therich.apps.core.members.usecase.AccountReadPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2020. 2. 27.
 */
@Component
public class AccountReadPersistenceImpl implements AccountReadPersistence {

    private final AccountJpaRepository repository;

    @Autowired
    public AccountReadPersistenceImpl(AccountJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account findId(String email) {
        return repository.findById(email).get();
    }
}
