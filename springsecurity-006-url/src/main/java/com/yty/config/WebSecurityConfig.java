package com.yty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Configuration
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        // 	我们指定了多种URL模式，任何用户都可以访问。具体来说，如果URL以 "/resources/" 开头，等于 "/signup"，或等于 "/about"，任何用户都可以访问一个请求
        // 任何以 "/admin/" 开头的URL将被限制给拥有 "ROLE_ADMIN" 角色的用户。你会注意到，由于我们调用的是 hasRole 方法，我们不需要指定 "ROLE_" 前缀。
        // 任何以"/db/"开头的URL都要求用户同时拥有 "ROLE_ADMIN" 和 "ROLE_DBA"。你会注意到，由于我们使用的是 hasRole 表达式，我们不需要指定 "ROLE_" 前缀。
        // 任何还没有被匹配的URL都会被拒绝访问。
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/resources/**", "/signup", "/about", "/login")
                .permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/student/**").hasAuthority("student:add")
                .requestMatchers("/teacher/**").hasRole("teacher")
                .anyRequest().authenticated()
        );
        http.formLogin().permitAll();

        return http.build();// 返回
    }

}
