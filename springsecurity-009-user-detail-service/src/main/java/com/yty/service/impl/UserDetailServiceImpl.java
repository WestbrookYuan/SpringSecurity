package com.yty.service.impl;

import com.yty.entity.LoginUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!StringUtils.hasText(username)){
            throw new UsernameNotFoundException("username not existed");
        }
        if (!"yty".equals(username)){
            throw new UsernameNotFoundException("username not correct");
        }
        return new LoginUser();
    }
}
