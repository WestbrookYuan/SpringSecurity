package com.yty.service.impl;

import com.yty.entity.SysUser;
import com.yty.service.SysUserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@SpringBootTest
public class SysUserServiceTest {
    @Resource
    private SysUserService service;
    @Test
    public void testService(){
        SysUser sysUser = service.getUser("obama");
        System.out.println(sysUser);
        Assert.notNull(sysUser, "not null user obama");
    }
}