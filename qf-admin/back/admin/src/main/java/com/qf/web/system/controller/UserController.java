package com.qf.web.system.controller;

import com.qf.common.core.controller.BaseController;
import com.qf.common.util.BaseResponse;
import com.qf.web.system.domain.dto.UserSearchDto;
import com.qf.web.system.domain.form.UserForm;
import com.qf.web.system.domain.vo.UserInfoVo;
import com.qf.web.system.domain.vo.UserPageVo;
import com.qf.web.system.service.SysUserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/{id}")
    public BaseResponse update(@PathVariable Long id, @RequestBody UserForm userForm) {
        log.info("修改用户,{userForm}" + userForm);
        log.info("修改用户,{userId}" + id);
        int row = userService.updateByUserId(id, userForm);
        return isOk(row);
    }

    @Schema(title = "删除用户")
    @DeleteMapping("/{ids}")
    public BaseResponse delete(@PathVariable String ids) {
        log.info("删除用户,{ids}" + ids);
        int row = userService.deleteByUserId(ids);
        return isOk(row);
    }

    @Schema(title = "重置密码")
    @PatchMapping("/{id}/password")
    public BaseResponse resetPassword(@PathVariable Long id) {
        log.info("重置密码,{userId}" + id);
        int row = userService.resetPasswordByUserId(id);
        return isOk(row);
    }

    @Schema(title = "获取分页用户")
    @GetMapping("/page")
    public BaseResponse getUserPage(@RequestBody UserSearchDto userSearch) {
        startPage();
        List<UserPageVo> userPageVoList = userService.getUserPage(userSearch);
        return BaseResponse.success(getData(userPageVoList));
    }

    @Schema(title = "根据uid获取用户信息")
    @GetMapping("/{userId}/form")
    public BaseResponse getUserByUid(@Parameter(description = "用户ID") @PathVariable Long userId) {
        UserForm form = userService.getUserFormByUid(userId);
        return BaseResponse.success(form);
    }
}