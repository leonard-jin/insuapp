//package com.therich.apps.configurations;
//
//import com.therich.apps.configurations.security.handlers.CustomLoginFailureHandler;
//import com.therich.apps.configurations.security.handlers.CustomLoginSuccessHandler;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
///**
// * Created by kh.jin on 2020. 2. 19.
// */
//
////@EnableWebSecurity
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    private final AuthenticationProvider provider;
//
//    private final CustomLoginSuccessHandler customLoginSuccessHandler;
//
//    private final CustomLoginFailureHandler customLoginFailureHandler;
//
//    @Autowired
//    public SecurityConfiguration(@Qualifier("customAuthenticationProvider") AuthenticationProvider provider,
//                                 CustomLoginSuccessHandler customLoginSuccessHandler,
//                                 CustomLoginFailureHandler customLoginFailureHandler) {
//        this.provider = provider;
//        this.customLoginSuccessHandler = customLoginSuccessHandler;
//        this.customLoginFailureHandler = customLoginFailureHandler;
//    }
//
//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/css/**", "/js/**", "/vendor/**", "/images/**", "/openapi/**", "/webjars/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.
//            authorizeRequests()
//                .antMatchers("/**/admin/**").hasRole("ADMIN")
//                .antMatchers("/**/owner/**").hasRole("OWNER")
//                .anyRequest().permitAll()
//                .and()
//            .formLogin()
//                .loginPage("/pages/signin")
//                .loginProcessingUrl("/signin")
//                .defaultSuccessUrl("/")
//                .successHandler(customLoginSuccessHandler)
//                .failureHandler(customLoginFailureHandler)
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .permitAll()
//                .and()
//            .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/")
//                .invalidateHttpSession(true)
//                .permitAll()
//                .and()
//            .exceptionHandling()
//                .accessDeniedPage("/error/denied")
//                .and()
//            .authenticationProvider(provider)
//            ;
//    }
//}