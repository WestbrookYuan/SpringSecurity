package com.yty.service.impl;

import com.yty.dao.SysMenuDao;
import com.yty.dao.SysUserDao;
import com.yty.entity.SysUser;
import com.yty.vo.SysUserVO;
import jakarta.annotation.Resource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SysMenuDao sysMenuDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserDao.getUser(username);
        System.out.println(user);
        if (Objects.isNull(user)){
            throw new UsernameNotFoundException("account doesn't exist");
        }

        List<String> strList = sysMenuDao.queryPermissionByUserId(user.getUserId());
        //使用stream流来转换
        List<SimpleGrantedAuthority> grantedAuthorities=strList
                .stream()
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        SysUserVO sysUserVO = new SysUserVO(user);
        sysUserVO.setSimpleGrantedAuthorities(grantedAuthorities);
        return sysUserVO;
    }
}
