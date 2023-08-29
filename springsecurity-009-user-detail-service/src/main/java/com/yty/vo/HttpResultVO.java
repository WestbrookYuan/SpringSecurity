package com.yty.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HttpResultVO {
    private Integer code;
    private String msg;
    private Object data;
}
