package com.qf.web.system.controller;

import com.qf.common.util.BaseResponse;
import com.qf.common.util.ToolUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author : sin
 * @date : 2024/1/14 18:40
 * @Description : 鉴权
 */
@Tag(name = "01.鉴权接口")
@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {
    /**
     * @author: sin
     * @Description 验证码
     */
    @Operation(summary = "验证码", description = "生成图片验证码")
    @GetMapping("/captcha")
    public BaseResponse getCaptcha() {
        Map<String, String> map = ToolUtils.GenerateVerifyCode();
        return BaseResponse.success(map);
    }
}