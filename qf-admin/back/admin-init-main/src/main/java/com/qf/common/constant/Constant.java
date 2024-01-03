package com.qf.common.constant;

import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author : sin
 * @date : 2023/11/27 22:57
 * @Description : 常量池
 */
@Configuration
public class Constant {

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

    /**
     * 验证码code
     */
    public static final String CAPTCHA_CODE = "captchaCode";

    /**
     * 验证码key
     */
    public static final String CAPTCHA_KEY = "captchaKey";

    /**
     * 验证码前缀
     */
    public static final String REDIS_CAPTCHA_PREFIX = "CAPTCHA:";

    /**
     * redis key前缀
     */
    public static final String REDIS_USER_KEY_PREFIX = "USER_KEY:";

    public static final String[] URLS = {
            LOGIN_URL,
            CAPTCHA_URL,
            ".css",
            "**.css",
            ".js",
            "**.js",
            "/doc.html",
            "/test",
            "/swagger-ui",
            "/swagger-ui/**",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/favicon.ico",
    };
}