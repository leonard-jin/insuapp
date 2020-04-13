package com.therich.apps.dataproviders;

import com.therich.apps.dataproviders.members.persistence.entity.Member;
import com.therich.apps.usecase.members.MemberReadDataProvider;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2020. 2. 26.
 */

@Component
public class MemberReadDataProviderImpl implements MemberReadDataProvider {


    @Override
    public Member findId(String email) {
        return null;
    }
}
