package com.yty.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Data
public class SysMenu implements Serializable {
    private Integer id;
    private Integer pid;
    private Integer type;
    private String name;
    private String code;
}