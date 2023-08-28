package com.yty.config;

import lombok.extern.slf4j.Slf4j;
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
 **/

@Configuration
@Slf4j
public class UserConfig {
    @Bean
    public UserDetailsService getUserDetailsService(){
        UserDetails user1 = User.builder()
                .username("yty")
                .password(getPasswordEncoder().encode("175147"))
                .roles("student")
                .build();
        UserDetails user2 = User.builder()
                .username("lhp")
                .password(getPasswordEncoder().encode("01209"))
                .authorities("teacher:search")
                .build();

        UserDetails user3 = User.builder()
                .username("hx")
                .password(getPasswordEncoder().encode("502835"))
                .authorities("teacher:search", "teacher:update", "teacher:add", "teacher:delete")
                .build();
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(user1);
        userDetailsManager.createUser(user2);
        userDetailsManager.createUser(user3);
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
