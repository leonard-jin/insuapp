package com.therich.apps.dataproviders;

import com.therich.apps.dataproviders.asset.BaseJpaTests;
import com.therich.apps.dataproviders.members.persistence.entity.Account;
import com.therich.apps.dataproviders.members.persistence.entity.Member;
import com.therich.apps.dataproviders.members.persistence.repository.AccountJpaRepository;
import com.therich.apps.dataproviders.members.persistence.repository.MemberJpaRepository;
import com.therich.apps.globals.codes.RoleCode;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kh.jin on 2020. 4. 3.
 */
class LoginDataProviderImplTest extends BaseJpaTests {
    @Autowired
    private MemberJpaRepository memberJpaRepository;

    @Autowired
    private AccountJpaRepository accountJpaRepository;

    private Member saveMember;
    private Account saveAccount;

    @Before
    public void setup() {

    }

    @Test
    public void test_find_account_ok() {
        saveMember = Member
                .builder()
                .email("admin@therich.com")
                .name("admin")
                .address("부산시 동래구 돈벌동")
                .mobile("010-4444-9999")
                .socialId("801111-4011991")
                .build();
        saveAccount = new Account(saveMember, "admin1234", RoleCode.ADMIN);
        //accountJpaRepository.save(saveAccount);
        String email = "admin@therich.com";


    }

}