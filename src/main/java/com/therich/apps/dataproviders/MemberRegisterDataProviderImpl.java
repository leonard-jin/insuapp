package com.therich.apps.dataproviders;

import com.therich.apps.dataproviders.members.persistence.entity.Account;
import com.therich.apps.dataproviders.members.persistence.entity.Member;
import com.therich.apps.dataproviders.members.persistence.repository.AccountJpaRepository;
import com.therich.apps.dataproviders.members.persistence.repository.MemberJpaRepository;
import com.therich.apps.usecase.members.MemberRegisterDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by kh.jin on 2020. 2. 25.
 */

@Component
public class MemberRegisterDataProviderImpl implements MemberRegisterDataProvider {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final MemberJpaRepository memberJpaRepository;
    private final AccountJpaRepository accountJpaRepository;

    @Autowired
    public MemberRegisterDataProviderImpl(MemberJpaRepository memberJpaRepository,
                                          AccountJpaRepository accountJpaRepository) {
        this.memberJpaRepository = memberJpaRepository;
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public boolean hasEmail(String email) {
        return Optional.ofNullable(memberJpaRepository.findByEmail(email)).isPresent();
    }

    @Override
    public boolean canRegisterRecommendEmail(String email) {
        return false;
    }

    @Override
    public void registerMember(Member member) {
        memberJpaRepository.save(member);
    }

    @Override
    public void registerAccount(Account account) {
        accountJpaRepository.save(account);
    }
}