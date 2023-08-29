package com.yty.dao;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@SpringBootTest
public class SysMenuDaoTest {
    @Resource
    private SysMenuDao sysMenuDao;
    @Test
    public void testQueryPermissionByUserId() {
        List<String> menuList = sysMenuDao.queryPermissionByUserId(1);
        assertTrue(!menuList.isEmpty()); }
}