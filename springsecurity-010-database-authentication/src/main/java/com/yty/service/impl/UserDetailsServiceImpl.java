package com.yty.service.impl;

import com.yty.entity.SysUser;
import com.yty.service.SysUserService;
import com.yty.vo.SysUserVO;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserService sysUserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserService.getUser(username);
        System.out.println(user);
        if (Objects.isNull(user)){
            throw new UsernameNotFoundException("account doesn't exist");
        }

        return new SysUserVO(user);
    }
}
