package com.qf.web.system.controller;

import com.qf.common.core.controller.BaseController;
import com.qf.common.util.BaseResponse;
import com.qf.web.system.domain.form.UserForm;
import com.qf.web.system.domain.vo.UserInfoVo;
import com.qf.web.system.service.SysUserService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author : sin
 * @date : 2024/1/14 20:06
 * @Description : 用户控制层
 */
@Tag(name = "02.用户接口")
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController extends BaseController {
    @Resource
    private SysUserService userService;

    @Schema(title = "获取当前用户信息")
    @RequestMapping("/me")
    public BaseResponse getUserInfo() {
        UserInfoVo user = userService.getUserInfo();
        return BaseResponse.success(user);
    }

    @Schema(title = "新增用户")
    @PostMapping("")
    public BaseResponse addUser(@RequestBody UserForm userForm) {
        log.info(userForm.toString());
        int row = userService.addUser(userForm);
        return isOk(row);
    }

    @Schema(title = "修改用户")
    @PutMapping("/{userId}")
    public BaseResponse update(@PathVariable Long userId, @RequestBody UserForm userForm) {
        log.info("修改用户,{userForm}" + userForm);
        log.info("修改用户,{userId}" + userId);
        int row = userService.updateByUserId(userId, userForm);
        return isOk(row);
    }
}