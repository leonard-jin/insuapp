package com.therich.apps.core.members.persistences;

import com.therich.apps.core.members.persistences.entities.Account;
import com.therich.apps.core.members.persistences.entities.Auth;
import com.therich.apps.core.members.persistences.entities.Member;
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

    @Autowired
    public MemberRepositoryServiceImpl(@Qualifier("memberJpaRepository") MemberJpaRepository memberJpaRepository) {
        this.memberJpaRepository = memberJpaRepository;
    }

    @Override
    public boolean hasMemberBySocialSecretId(String socialSecretId) {
        return memberJpaRepository.findBySocialId(socialSecretId) == null ? true : false;
    }

    @Override
    public void createMember(Member member) {

    }

    @Override
    public void createAccount(Account account) {

    }

    @Override
    public void createAuth(Auth auth) {

    }
}
