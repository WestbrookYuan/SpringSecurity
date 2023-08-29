package com.yty.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Slf4j
@RestController
public class CurrentUserController {
    @GetMapping("/getLoginUser1")
    public Authentication getLoginUser1(Authentication authentication){
        return authentication;
    }

    @GetMapping("/getLoginUser2")
    public Principal getLoginUser2(Principal principal){
        return principal;
    }

    @GetMapping("/getLoginUser3")
    public Principal getLoginUser3(){
        // get security context, then get authentication
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
