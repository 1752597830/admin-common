package com.qf.web.system.controller;

import com.qf.common.util.BaseResponse;
import com.qf.web.system.domain.vo.UserInfoVo;
import com.qf.web.system.service.SysUserService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : sin
 * @date : 2024/1/14 20:06
 * @Description : 用户控制层
 */
@Tag(name = "02.用户接口")
@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private SysUserService userService;

    @Schema(title = "获取当前用户信息")
    @RequestMapping("/me")
    public BaseResponse getUserInfo() {
        UserInfoVo user = userService.getUserInfo();
        return BaseResponse.success(user);
    }
}