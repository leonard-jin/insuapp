package com.therich.apps.configurations.security;

import com.therich.apps.dataproviders.members.persistence.entity.Account;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Created by kh.jin on 2020. 3. 2.
 */
public class CustomAuthentication extends UsernamePasswordAuthenticationToken {
    private static final long serialVersionUID = 1L;

    // TODO : 왜 접근제한자가 없을까요?
    Account account;

    public CustomAuthentication(String id, String password, List<GrantedAuthority> grantedAuthorityList, Account account) {
        super(id, password, grantedAuthorityList);
        this.account = account;
    }
}
