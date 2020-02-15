package com.therich.apps.core.members.services;

import com.therich.apps.core.members.persistences.MemberRepositoryServiceImpl;
import com.therich.apps.entrypoints.any.request.JoinRequest;
import com.therich.apps.globals.exceptions.BusinessException;
import com.therich.apps.globals.exceptions.codes.BusinessErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by kh.jin on 2020. 2. 15.
 */
@Service
public class MemberRegisterServiceImpl implements MemberRegisterService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final MemberRepositoryServiceImpl repository;

    @Autowired
    public MemberRegisterServiceImpl(@Qualifier("memberRepositoryServiceImpl") MemberRepositoryServiceImpl repository) {
        this.repository = repository;
    }

    @Override
    public void join(JoinRequest request) {
        log.debug(">>>>> start member join.");

        // 1. social secret id 중복 체크
        if (repository.hasMemberBySocialSecretId(request.getSocialId())) {
            throw new BusinessException(BusinessErrorCode.DUPLICATE);
        }

        // 2. id 생성

        // 3. tb_member 저장

        // 4. tb_account 저장

        // 4. 패스워드 생성

        // 5. tb_auth 저장
        log.debug(">>>>> complete member join.");
    }
}
