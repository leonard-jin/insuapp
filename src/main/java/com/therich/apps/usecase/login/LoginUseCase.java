package com.therich.apps.usecase.login;

import com.therich.apps.dataproviders.members.persistence.entity.Account;
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

    private final LoginDataProvider dataProvider;

    @Autowired
    public LoginUseCase(LoginDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }
    public Account login(String id, String password) {
        Account account = dataProvider.findAccount(id);
        if (account == null) {
            throw new BusinessException(BusinessErrorCode.NO_DATA);
        }
        log.debug("[Login] result account: {}", account);

        if (!verifyCredential(account, password)) {
            throw new BusinessException(BusinessErrorCode.NOT_MATCH);
        }

        // todo : 로그인 성공 시 여러가지 비지니스 (이력, 로그인 시간, 등등)
        return account;
    }

    private boolean verifyCredential(Account account, String password) throws NoSuchAlgorithmException {
        String salt = account.getSalt();
        String encypt = SHA256EncoderHelper.getInstance().encypt(password, salt);
        return account.getPassword().equals(encypt);
    }
}