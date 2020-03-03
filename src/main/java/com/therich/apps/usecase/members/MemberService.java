package com.therich.apps.usecase.members;

import com.therich.apps.dataproviders.persistences.members.entities.Member;
import org.springframework.stereotype.Service;

/**
 * Created by kh.jin on 2020. 2. 26.
 */
@Service
public class MemberService {

    public Member getMemberByEmail(String email) {
        return Member.builder().build();
    }
}
