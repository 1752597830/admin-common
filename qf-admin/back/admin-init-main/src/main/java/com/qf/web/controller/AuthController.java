package com.qf.web.controller;

import com.qf.common.utils.BaseResponse;
import com.qf.common.utils.ToolUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author : sin
 * @date : 2023/12/15 17:14
 * @Description : 认证控制器
 */
@RestController
@Tag(name = "01.认证中心")
@RequestMapping("/auth")
public class AuthController {
    /**
     * 获取验证码
     */

    @GetMapping("/captcha")
    public BaseResponse getCaptcha() {
        Map<String, String> map = ToolUtils.GenerateVerifyCode();
        return BaseResponse.success(map);
    }
}