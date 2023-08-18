package com.yty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @GetMapping("/query")
    public String queryInfo(){
        return "I am a teacher";
    }
}
