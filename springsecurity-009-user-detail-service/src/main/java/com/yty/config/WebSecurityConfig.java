package com.yty.config;

import com.yty.handler.AccessDeniedHandler;
import com.yty.handler.AuthenticationFailHandler;
import com.yty.handler.AuthenticationSuccessHandler;
import com.yty.handler.LogoutHandler;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class WebSecurityConfig {
    @Resource
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Resource
    private AuthenticationFailHandler authenticationFailHandler;
    @Resource
    private LogoutHandler logoutHandler;
    @Resource
    private AccessDeniedHandler accessDeniedHandler;
    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception{
        http.formLogin()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailHandler)
                .permitAll();
        http.authorizeHttpRequests((authorize) ->{
            authorize.requestMatchers("/teacher/**").hasRole("teacher");
            authorize.anyRequest().authenticated();
        } );

        http.logout().logoutSuccessHandler(logoutHandler);
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

        return http.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
