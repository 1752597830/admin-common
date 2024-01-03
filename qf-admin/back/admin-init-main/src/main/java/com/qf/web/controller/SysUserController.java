package com.qf.web.controller;

import com.qf.common.core.controller.BaseController;
import com.qf.common.core.page.PageResult;
import com.qf.common.utils.BaseResponse;
import com.qf.web.domain.dto.UserPage;
import com.qf.web.domain.vo.UserForm;
import com.qf.web.domain.vo.UserPageVo;
import com.qf.web.domain.vo.UserVo;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.qf.web.service.SysUserService;
import java.util.List;

/**
 * @author : sin
 * @date : 2023/12/13 12:54
 * @Description :
 */

@RestController
@Tag(name = "02.用户接口")
@RequestMapping("/users")
@Slf4j
public class SysUserController extends BaseController {

    @Resource
    SysUserService sysUserService;

    /**
     * 根据uid获取用户
     */
    @Schema(title = "根据uid获取用户")
    @GetMapping("/{userId}/form")
    public BaseResponse getUserByUid(@Parameter(description = "用户ID") @PathVariable Long userId) {
        UserForm form = sysUserService.getUserFormByUid(userId);
        return BaseResponse.success(form);
    }

    /**
     * 获取当前用户信息
     */
    @Schema(title = "获取当前用户信息")
    @GetMapping("/me")
    public BaseResponse getUserInfo() {
        UserVo userVo = sysUserService.getUserInfo();
        System.out.println(userVo);
        return BaseResponse.success(userVo);
    }

    /**
     * 获取分页用户
     */
    @Schema(title = "获取分页用户")
    @GetMapping("/page")
    public BaseResponse getPage(UserPage userPage) {
        startPage();
        List<UserPageVo> userPageVoList = sysUserService.getPage(userPage);
        PageResult pageResult = getData(userPageVoList);
        return BaseResponse.success(pageResult);
    }

    /**
     * 新增用户
     */
    @PostMapping("")
    public BaseResponse save(@RequestBody UserForm userForm) {
        log.info("新增用户,{userForm}" + userForm);
        return toAjax(sysUserService.save(userForm));
    }
    /**
     * 修改用户信息
     */
    @PutMapping("/{userId}")
    public BaseResponse update(@PathVariable Long userId,@RequestBody UserForm userForm) {
        log.info("修改用户,{userForm}" + userForm);
        log.info("修改用户,{userId}" + userId);
        return toAjax(sysUserService.updateByUserId(userForm));
    }

    /**
     * 删除用户  逻辑删除
     */
    @DeleteMapping("/{ids}")
    public BaseResponse delete(@PathVariable String ids) {
        return toAjax(sysUserService.deleteBatchIds(ids));
    }
}