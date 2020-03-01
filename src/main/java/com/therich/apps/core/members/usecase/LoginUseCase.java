package com.therich.apps.core.members.usecase;

import com.therich.apps.core.members.codes.RoleCode;
import com.therich.apps.core.members.persistences.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kh.jin on 2020. 2. 26.
 */
@Service
public class LoginUseCase {

    private final AccountReadPersistence persistence;

    @Autowired
    public LoginUseCase(AccountReadPersistence persistence) {
        this.persistence = persistence;
    }

    public AccountDomain getUsers(String email) {
        Account account = persistence.findId(email);
        if (account == null) {
            return null;
        }
        return mappingToAccountDomain(account);
    }

    @AllArgsConstructor
    @Builder
    public static class AccountDomain {
        private String email;
        private String password;
        private String salt;
        private RoleCode role;
    }

    private AccountDomain mappingToAccountDomain(Account account) {
        return AccountDomain.builder()
                .email(account.getEmail())
                .password(account.getPassword())
                .salt(account.getSalt())
                .role(account.getRole())
                .build();
    }
}