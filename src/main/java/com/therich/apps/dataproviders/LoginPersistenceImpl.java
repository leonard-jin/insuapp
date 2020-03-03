package com.therich.apps.dataproviders;

import com.therich.apps.dataproviders.persistences.members.entities.Account;
import com.therich.apps.dataproviders.persistences.members.entities.Member;
import com.therich.apps.dataproviders.persistences.members.repositories.AccountJpaRepository;
import com.therich.apps.dataproviders.persistences.members.repositories.MemberJpaRepository;
import com.therich.apps.usecase.login.LoginPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2020. 3. 2.
 */
@Component
public class LoginPersistenceImpl implements LoginPersistence {

    private final AccountJpaRepository accountJpaRepository;

    private final MemberJpaRepository memberJpaRepository;

    @Autowired
    public LoginPersistenceImpl(AccountJpaRepository accountJpaRepository, MemberJpaRepository memberJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
        this.memberJpaRepository = memberJpaRepository;
    }

    @Override
    public Account findAccount(String email) {
        return accountJpaRepository.getOne(email);
    }

    @Override
    public Member findMember(String email) {
        return memberJpaRepository.findByEmail(email);
    }
}
