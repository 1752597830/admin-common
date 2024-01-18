package com.qf.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : sin
 * @date : 2024/1/14 12:24
 * @Description : 配置跨域请求
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //.allowedOrigins("*")
                .allowCredentials(false)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .allowedOriginPatterns("*")
                // 设置允许的header属性
                .allowedHeaders("*")
                .maxAge(3600);
    }
}