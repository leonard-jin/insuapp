package com.therich.apps.core.members.services;

import com.therich.apps.entrypoints.any.request.JoinRequest;

/**
 * Created by kh.jin on 2020. 2. 15.
 */
public interface MemberRegisterService {
    void join(JoinRequest request);
}
