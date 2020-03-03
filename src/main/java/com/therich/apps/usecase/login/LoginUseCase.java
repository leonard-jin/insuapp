package com.therich.apps.usecase.login;

import com.therich.apps.dataproviders.persistences.members.entities.Account;
import com.therich.apps.globals.exceptions.AppsException;
import com.therich.apps.globals.exceptions.BusinessException;
import com.therich.apps.globals.exceptions.codes.BusinessErrorCode;
import com.therich.apps.globals.services.encrypt.SHA256EncoderHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

/**
 * Created by kh.jin on 2020. 2. 26.
 */
@Transactional(readOnly = true)
@Service
public class LoginUseCase {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final LoginPersistence persistence;

    @Autowired
    public LoginUseCase(LoginPersistence persistence) {
        this.persistence = persistence;
    }

    public Account login(String id, String password) {
        Account account = persistence.findAccount(id);
        if (account == null) {
            throw new BusinessException(BusinessErrorCode.NO_DATA);
        }
        log.debug("[Login] result account: {}", account);

        if (!verifyCredential(account, password)) {
            throw new BusinessException(BusinessErrorCode.NOT_MATCH);
        }

        account.setMember(persistence.findMember(id));
        log.debug("[LoginUseCase] result : {}", account);

        //TODO : account 의 데이터 초기화, 로그인 이력 등 비지니스 처리
        return account;
    }

    private boolean verifyCredential(Account account, String password) {
        try {
            String salt = account.getSalt();
            String encypt = SHA256EncoderHelper.getInstance().encypt(password, salt);
            return account.getPassword().equals(encypt);
        } catch (NoSuchAlgorithmException e) {
            log.error("error. verified password.");
            throw new AppsException();
        }
    }
}