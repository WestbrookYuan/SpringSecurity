package com.yty.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yty.vo.HttpResultVO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Component
@Slf4j
public class AuthenticationFailHandler implements AuthenticationFailureHandler {
    @Resource
    private ObjectMapper objectMapper;
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        HttpResultVO vo = HttpResultVO.builder()
                .code(2)
                .msg("login failed")
                .data(null)
                .build();
        String resultJson = objectMapper.writeValueAsString(vo);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(resultJson);
        writer.flush();
    }
}
