package com.therich.apps.dataproviders;

import com.therich.apps.dataproviders.persistences.members.entities.Member;
import com.therich.apps.dataproviders.persistences.members.repositories.MemberJpaRepository;
import com.therich.apps.usecase.members.MemberReadPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2020. 2. 26.
 */

@Component
public class MemberReadPersistenceImpl implements MemberReadPersistence {
    private final MemberJpaRepository repository;

    @Autowired
    public MemberReadPersistenceImpl(MemberJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Member findId(String email) {
        return repository.findByEmail(email);
    }
}
