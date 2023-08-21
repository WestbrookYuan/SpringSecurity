package com.yty.password;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/

@Slf4j
public class EncoderTest {

    @Test
    public void testEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode1 = bCryptPasswordEncoder.encode("123456");
        String encode2 = bCryptPasswordEncoder.encode("123456");
        String encode3 = bCryptPasswordEncoder.encode("123456");
        log.info(encode1);
        log.info(encode2);
        log.info(encode3);
        // $2a$10$OoIToIERkODpQXmI15rM/ObphPCrL/jS/z46CDL0nmWcy1i/GKn2e
        // $2a$10$cjXhmq6fqW57IS5AdseGY.6u92r2SSxgW7iezOtDLXrChV1ZluWoi
        // $2a$10$QVMDgcfdcJKsQhl4A9DTO.OpUYh/WjZN1DMGszhkjf4WCCtNXdKIC

        boolean matches1 = bCryptPasswordEncoder.matches("123456", encode1);
        boolean matches2 = bCryptPasswordEncoder.matches("123456", encode2);
        boolean matches3 = bCryptPasswordEncoder.matches("123456", encode3);
        log.info(String.valueOf(matches1));
        log.info(String.valueOf(matches2));
        log.info(String.valueOf(matches3));
        Assertions.assertTrue(matches1 && matches2 && matches3);



    }
}
