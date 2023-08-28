package com.yty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception{
        http.formLogin().permitAll();
        http.authorizeHttpRequests((authorize) ->{
//            authorize.requestMatchers("/resources/**", "/signup", "/about", "/login").permitAll();
//            authorize.requestMatchers("/teacher/search").hasAuthority("");
            authorize.anyRequest().authenticated();
        } );
        return http.build();
    }
}
