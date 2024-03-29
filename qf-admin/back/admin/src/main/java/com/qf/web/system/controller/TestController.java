package com.qf.web.system.controller;

import com.qf.web.system.domain.entity.SysUser;
import com.qf.web.system.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : sin
 * @date : 2024/1/14 11:10
 * @Description :
 */
@RestController
public class TestController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/test")
    public String test(){
        SysUser sysUser = sysUserService.selectByUsername("admin");
        //System.out.println(sysUser);
        return "test";
    }
}