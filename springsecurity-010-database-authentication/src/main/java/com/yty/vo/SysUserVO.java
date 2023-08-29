package com.yty.vo;

import com.yty.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
public class SysUserVO implements UserDetails {
    private final SysUser user;

    public SysUserVO(SysUser user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
