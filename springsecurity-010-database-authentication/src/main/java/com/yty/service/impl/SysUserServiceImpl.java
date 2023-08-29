package com.yty.service.impl;

import com.yty.dao.SysUserDao;
import com.yty.entity.SysUser;
import com.yty.service.SysUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;
    @Override
    public SysUser getUser(String username) {
        return sysUserDao.getUser(username);
    }
}
