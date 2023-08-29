package com.yty.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Data
public class SysUser implements Serializable {
    private Integer userId;
    private String username;
    private String password;
    private String sex;
    private String address;
    private Integer enabled;
    private Integer accountNoExpired;
    private Integer credentialsNoExpired;
    private Integer accountNoLocked;
}
