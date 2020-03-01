package com.therich.apps.core.members.usecase;

import com.therich.apps.core.members.persistences.entities.Member;
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
