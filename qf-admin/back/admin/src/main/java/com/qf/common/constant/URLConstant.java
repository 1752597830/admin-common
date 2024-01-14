package com.qf.common.constant;

import org.springframework.context.annotation.Configuration;

/**
 * @author : sin
 * @date : 2024/1/14 15:56
 * @Description : 定义放行url常量
 */
@Configuration
public class URLConstant {
    /**
     * 登录url
     */
    public static final String LOGIN_URL = "/auth/login";
    /**
     * 验证码url
     */
    public static final String CAPTCHA_URL = "/auth/captcha";
    /**
     * 退出登录url
     */
    public static final String LOGOUT_URL = "/auth/logout";

    public static final String[] URLS = {
            LOGIN_URL,
            CAPTCHA_URL,
            ".css",
            "**.css",
            ".js",
            "**.js",
            "/doc.html",
            "/swagger-ui",
            "/swagger-ui/**",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/favicon.ico",
            "/getIcon"
    };
}