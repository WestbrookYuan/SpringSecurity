package com.yty.controller;

import com.yty.service.TeacherService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    @GetMapping("add")
    public String addInfo(){
        log.info("10");
        return teacherService.add();
    }

    @GetMapping("update")
    public String updateInfo(){
        return teacherService.update();
    }

    @GetMapping("/search")
    public String searchInfo(){
        return teacherService.search();
    }

    @GetMapping("/delete")
    public String deleteInfo(){
        return teacherService.delete();
    }
}
