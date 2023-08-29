package com.yty.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yty.vo.HttpResultVO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 *
 **/
@Component
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {
    @Resource
    private ObjectMapper objectMapper;
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        HttpResultVO vo = HttpResultVO.builder()
                .code(4)
                .msg("access denied")
                .data(null)
                .build();

        String resultJson = objectMapper.writeValueAsString(vo);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(resultJson);
        writer.flush();
    }
}
