package com.qf.web.system.controller;

import com.qf.common.core.controller.BaseController;
import com.qf.common.util.BaseResponse;
import com.qf.web.system.domain.dto.UserSearchDto;
import com.qf.web.system.domain.form.PwdForm;
import com.qf.web.system.domain.form.UserForm;
import com.qf.web.system.domain.vo.UserInfoVo;
import com.qf.web.system.domain.vo.UserPageVo;
import com.qf.web.system.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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

    @Operation(summary = "获取当前用户信息")
    @RequestMapping("/me")
    public BaseResponse getUserInfo() {
        UserInfoVo user = userService.getUserInfo();
        return BaseResponse.success(user);
    }

    @Operation(summary = "新增用户")
    @PostMapping("")
    public BaseResponse addUser(@Valid @RequestBody UserForm userForm) {
        log.info(userForm.toString());
        int row = userService.addUser(userForm);
        return isOk(row);
    }

    @Operation(summary = "修改用户")
    @PutMapping("/{id}")
    public BaseResponse update(@PathVariable @NotBlank(message = "用户id不能为空") Long id, @Valid @RequestBody UserForm userForm) {
        log.info("修改用户,{userForm}" + userForm);
        log.info("修改用户,{userId}" + id);
        int row = userService.updateByUserId(id, userForm);
        return isOk(row);
    }

    @Schema(title = "删除用户")
    @Operation(summary = "删除用户",description = "解析 , 分隔开的用户id,进行逻辑删除 is_deleted=1")
    @DeleteMapping("/{ids}")
    public BaseResponse delete(@PathVariable @NotBlank(message = "用户id不能为空") String ids) {
        log.info("删除用户,{ids}" + ids);
        int row = userService.deleteByUserId(ids);
        return isOk(row);
    }

    @Schema(title = "重置密码")
    @Operation(summary = "重置密码",description = "重置用户为默认密码123456")
    @PatchMapping("/{id}/password")
    public BaseResponse resetPassword(@PathVariable @NotBlank(message = "用户id不能为空") Long id) {
        log.info("重置密码,{userId}" + id);
        int row = userService.resetPasswordByUserId(id);
        return isOk(row);
    }

    @Operation(summary = "获取分页用户信息",description = "根据用户名、手机号、开启状态来获取分页用户信息")
    @GetMapping("/page")
    public BaseResponse getUserPage(@RequestBody @Valid UserSearchDto userSearch) {
        startPage();
        List<UserPageVo> userPageVoList = userService.getUserPage(userSearch);
        return BaseResponse.success(getData(userPageVoList));
    }

    @Operation(summary = "获取用户信息",description = "根据用户ID获取用户信息")
    @GetMapping("/{userId}/form")
    public BaseResponse getUserByUid(@NotBlank(message = "用户id不能为空") @PathVariable Long userId) {
        UserForm form = userService.getUserFormByUid(userId);
        return BaseResponse.success(form);
    }

    @Operation(summary = "修改密码",description = "传入原密码和新密码,校验成功后进行修改")
    @PostMapping("/password")
    public BaseResponse changePassword(@RequestBody @Valid PwdForm pwdForm) {
        log.info(pwdForm.toString());
        int row = userService.changePassword(pwdForm);
        return isOk(row);
    }
}