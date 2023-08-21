package com.yty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
        /**
         * authority和roles哪个在后面哪个起作用
         */
        UserDetails user = User.builder()
                .username("xjf")
                .password(passwordEncoder().encode("175146"))
                .roles("student")
                .authorities("student:add", "student:delete")
                .build();
        UserDetails user1 = User.builder()
                .username("wc")
                .password(passwordEncoder().encode("175148"))
                .authorities("teacher:add", "teacher:delete")
                .roles("teacher").build();
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
        return new BCryptPasswordEncoder();
    }
}
