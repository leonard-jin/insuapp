package com.therich.apps.core.members.services;

import com.therich.apps.core.members.persistences.MemberRepositoryServiceImpl;
import com.therich.apps.core.members.persistences.codes.BankCode;
import com.therich.apps.core.members.persistences.codes.RoleCode;
import com.therich.apps.core.members.persistences.entities.Account;
import com.therich.apps.core.members.persistences.entities.Member;
import com.therich.apps.entrypoints.any.request.JoinRequest;
import com.therich.apps.globals.exceptions.BusinessException;
import com.therich.apps.globals.exceptions.codes.BusinessErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kh.jin on 2020. 2. 15.
 */
@Service
public class MemberRegisterServiceImpl implements MemberRegisterService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final MemberRepositoryServiceImpl repository;

    private final static String ERR_DUPLICATE_EMAIL_MSG = "이미 등록된 주민번호입니다.";

    @Autowired
    public MemberRegisterServiceImpl(@Qualifier("memberRepositoryServiceImpl") MemberRepositoryServiceImpl repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void join(JoinRequest request) {
        log.debug(">>>>> start member join.");

        if (repository.hasMemberByEmail(request.getEmail())) {
            log.error("Already exist email address.");
            throw new BusinessException(BusinessErrorCode.DUPLICATE, this.ERR_DUPLICATE_EMAIL_MSG);
        }

        Member member = repository.createMember(Member.builder()
                .email(request.getEmail())
                .name(request.getName())
                .mobile(request.getMobile())
                .postCode(request.getPostCode())
                .address(request.getAddress())
                .socialId(request.getSocialId())
                .bankCode(BankCode.from(request.getBankCode()))
                .bankAccount(request.getBankAccount())
                .build());

        log.debug("[member] created member. {}", member);

        Account account = repository.createAccount(Account.builder()
                .no(member.getNo())
                .ownerLevel(1)
                .role(RoleCode.OWNER)
                .build());

        log.debug("[member] created account. {}", account);

        // 4. 패스워드 생성


        // 5. tb_auth 저장
        log.debug(">>>>> complete member join.");
    }
}
