package com.yty.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
public interface SysMenuDao {
    List<String> queryPermissionByUserId(@Param("userId") Integer userId);
}
