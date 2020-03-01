package com.therich.apps.core.members.persistences;

import com.therich.apps.core.members.persistences.entities.Member;
import com.therich.apps.core.members.persistences.repositories.MemberJpaRepository;
import com.therich.apps.core.members.usecase.MemberReadPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2020. 2. 26.
 */

@Component
public class MemberReadPersistenceImpl implements MemberReadPersistence {
    private final MemberJpaRepository memberJpaRepository;

    @Autowired
    public MemberReadPersistenceImpl(MemberJpaRepository memberJpaRepository) {
        this.memberJpaRepository = memberJpaRepository;
    }

    @Override
    public Member findId(String email) {
        return null;
    }
}
