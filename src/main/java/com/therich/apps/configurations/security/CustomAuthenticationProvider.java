package com.therich.apps.configurations.security;

import com.therich.apps.dataproviders.persistences.members.entities.Account;
import com.therich.apps.globals.exceptions.BusinessException;
import com.therich.apps.globals.exceptions.codes.BusinessErrorCode;
import com.therich.apps.usecase.login.LoginUseCase;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kh.jin on 2020. 3. 2.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final static String USERNAME_NOT_FOUND_MSG = "not found username.";
    private final static String BAD_CREDENTIALS_MSG = "not matched password.";

    private final LoginUseCase loginUseCase;

    @Autowired
    public CustomAuthenticationProvider(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id = authentication.getName();
        String password = authentication.getCredentials().toString();
        log.debug("[authenticate] id : {}, password : {}", id, password);
        if (StringUtils.isEmpty(id)) {
            throw new UsernameNotFoundException("");
        }
        return this.authenticate(id, password);
    }

    public Authentication authenticate(String id, String password) throws AuthenticationException {
        Account account = null;
        try {
            account = loginUseCase.login(id, password);
            List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
            String role = account.getRole().name();
            log.debug("User role : {}", role);
            grantedAuthorityList.add(new SimpleGrantedAuthority(role));

            return new CustomAuthentication(id, password, grantedAuthorityList, account);
        } catch (BusinessException e) {
            BusinessErrorCode code = e.getCode();
            switch (code) {
                case NO_DATA:
                    log.error("Not found user.");
                    throw new UsernameNotFoundException(USERNAME_NOT_FOUND_MSG);
                case NOT_MATCH:
                    log.error("Not matched password.");
                    throw new BadCredentialsException(BAD_CREDENTIALS_MSG);
                default:
                    throw new UnknownError("");
            }
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}