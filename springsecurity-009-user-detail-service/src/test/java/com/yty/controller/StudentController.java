package com.yty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/query")
    public String queryInfo(){
        return "I am a student";
    }
}
