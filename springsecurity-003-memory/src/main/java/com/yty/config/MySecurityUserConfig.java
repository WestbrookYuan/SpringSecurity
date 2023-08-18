package com.yty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 * 定义一个Bean 用户详情服务接口
 **/
@Configuration
public class MySecurityUserConfig {
    @Bean
    public UserDetailsService userDetailService(){
        UserDetails user = User.builder().username("xjf").password("175146").roles("student").build();
        UserDetails user1 = User.builder().username("wc").password("175148").roles("teacher").build();
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(user);
        inMemoryUserDetailsManager.createUser(user1);
        return inMemoryUserDetailsManager;
    }

    /**
     * 密码编码器 但不加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
