package com.therich.apps.core.members.usecase;

import com.therich.apps.core.members.persistences.entities.Member;

/**
 * Created by kh.jin on 2020. 2. 26.
 */
public interface MemberReadPersistence {
    Member findId(String email);
}
