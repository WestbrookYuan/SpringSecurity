package com.yty.vo;

import com.yty.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
public class SysUserVO implements UserDetails {
    private final SysUser user;
    private List<SimpleGrantedAuthority> simpleGrantedAuthorities;

    public SysUserVO(SysUser user) {
        this.user = user;
    }

    public void setSimpleGrantedAuthorities(List<SimpleGrantedAuthority> simpleGrantedAuthorities) {
        this.simpleGrantedAuthorities = simpleGrantedAuthorities;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        String password = this.user.getPassword();
        this.user.setPassword(null);
        return password;
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.user.getAccountNoExpired().equals(1);
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.user.getAccountNoLocked().equals(1);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.user.getCredentialsNoExpired().equals(1);
    }

    @Override
    public boolean isEnabled() {
        return this.user.getEnabled().equals(1);
    }
}
