package com.therich.apps.usecase.members;

import com.therich.apps.dataproviders.persistences.members.entities.Member;

/**
 * Created by kh.jin on 2020. 2. 26.
 */
public interface MemberReadPersistence {
    Member findId(String email);
}
