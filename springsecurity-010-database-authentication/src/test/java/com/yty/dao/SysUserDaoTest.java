package com.yty.dao;

import com.yty.entity.SysUser;
import jakarta.annotation.Resource;
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
class SysUserDaoTest {
    @Resource
    private SysUserDao dao;
    @Test
    public void testDao(){
        SysUser obama = dao.getUser("obama");
        System.out.println(obama);
        Assert.notNull(obama, "get obama SysUser");
    }

}