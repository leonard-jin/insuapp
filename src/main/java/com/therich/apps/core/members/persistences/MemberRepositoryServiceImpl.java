package com.therich.apps.core.members.persistences;

import com.therich.apps.core.members.persistences.entities.Account;
import com.therich.apps.core.members.persistences.entities.Member;
import com.therich.apps.core.members.persistences.repositories.AccountJpaRepository;
import com.therich.apps.core.members.persistences.repositories.MemberJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2020. 2. 15.
 */
@Component
public class MemberRepositoryServiceImpl implements MemberRepositoryService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final MemberJpaRepository memberJpaRepository;
    private final AccountJpaRepository accountJpaRepository;

    @Autowired
    public MemberRepositoryServiceImpl(@Qualifier("memberJpaRepository") MemberJpaRepository memberJpaRepository,
                                       @Qualifier("accountJpaRepository") AccountJpaRepository accountJpaRepository) {
        this.memberJpaRepository = memberJpaRepository;
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public boolean hasMemberByEmail(String email) {
        Member member = memberJpaRepository.findByEmail(email);
        log.debug("find by email member : {}", member);
        if (member == null) {
            return true;
        }
        return false;
    }

    @Override
    public Member createMember(Member member) {
        return memberJpaRepository.save(member);
    }

    @Override
    public Account createAccount(Account account) {
        return accountJpaRepository.save(account);
    }
}