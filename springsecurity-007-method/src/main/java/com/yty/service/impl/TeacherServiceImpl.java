package com.yty.service.impl;

import com.yty.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    @Override
    @PreAuthorize("hasAuthority('teacher:add')")
    public String add() {
        log.info("add");
        return "add";
    }

    @Override
    @PreAuthorize("hasAuthority('teacher:update')")
    public String update() {
        log.info("update");
        return "update";
    }

    @Override
    @PreAuthorize("hasAuthority('teacher:search')")
    public String search() {
        log.info("search");
        return "search";
    }

    @Override
    @PreAuthorize("hasAuthority('teacher:delete')")
    public String delete() {
        log.info("delete");
        return "delete";
    }
}
