package com.yty.service.impl;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@SpringBootTest
public class UserDetailServiceImplTest {

    @Resource
    private UserDetailsService userDetailsService;

    @Test
    public void testUserDetailsService(){
        UserDetails user = userDetailsService.loadUserByUsername("obama");
        Assertions.assertNotNull(user);
    }
}