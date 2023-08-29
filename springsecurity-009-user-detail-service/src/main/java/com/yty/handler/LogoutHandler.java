package com.yty.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yty.vo.HttpResultVO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Component
public class LogoutHandler implements LogoutSuccessHandler {

    @Resource
    private ObjectMapper objectMapper;
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpResultVO vo = HttpResultVO.builder()
                .data(null)
                .code(3)
                .msg("logout successful")
                .build();

        String resultJson = objectMapper.writeValueAsString(vo);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(resultJson);
        writer.flush();
    }
}
