package com.therich.apps.usecase.members;

import com.therich.apps.dataproviders.members.persistence.entity.Member;

/**
 * Created by kh.jin on 2020. 2. 26.
 */
public interface MemberReadDataProvider {
    Member findId(String email);
}
