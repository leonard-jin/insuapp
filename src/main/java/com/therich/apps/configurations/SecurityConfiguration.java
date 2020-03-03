package com.therich.apps.configurations;

import com.therich.apps.configurations.security.CustomAuthenticationProvider;
import com.therich.apps.configurations.security.LoginFailureHandler;
import com.therich.apps.configurations.security.LoginSuccessHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//
///**
// * Created by kh.jin on 2020. 2. 19.
// */
//
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CustomAuthenticationProvider customAuthenticationProvider;

    private final LoginSuccessHandler loginSuccessHandler;

    private final LoginFailureHandler loginFailureHandler;

    @Autowired
    public SecurityConfiguration(CustomAuthenticationProvider customAuthenticationProvider, LoginSuccessHandler loginSuccessHandler, LoginFailureHandler loginFailureHandler) {
        this.customAuthenticationProvider = customAuthenticationProvider;
        this.loginSuccessHandler = loginSuccessHandler;
        this.loginFailureHandler = loginFailureHandler;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**", "/js/**", "/vendor/**", "/images/**", "/openapi/**", "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**/admin/**").hasRole("ADMIN")
                .antMatchers("/**/owner/**").hasRole("OWNER")
                .anyRequest().permitAll();

        http.csrf().disable();

        http.formLogin()
                .loginPage("/pages/signin")
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)
        ;

        http.logout();
        http.authenticationProvider(customAuthenticationProvider);
    }
}