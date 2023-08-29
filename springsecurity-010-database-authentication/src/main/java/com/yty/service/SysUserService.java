package com.yty.service;

import com.yty.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
public interface SysUserService {
    SysUser getUser(String username);
}
