package com.qf.security.config;

import com.qf.common.constant.URLConstant;
import com.qf.common.util.BaseResponse;
import com.qf.common.util.ServletUtils;
import com.qf.common.util.SingletonRegistry;
import com.qf.filter.JwtAuthenticationTokenFilter;
import com.qf.security.auth.MyauthorizationManager;
import com.qf.security.exception.NoAuthenticationEntryPoint;
import com.qf.security.handler.LoginFailHandler;
import com.qf.security.handler.LoginSuccessHandler;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author : sin
 * @date : 2024/1/14 12:23
 * @Description : 配置类
 */
@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

    /**
     * 自定义权限校验
     */
    @Resource
    private MyauthorizationManager authorizationManager;

    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /**
         * 配置放行的访问接口
         */
        http.authorizeHttpRequests(e -> e.requestMatchers(URLConstant.URLS).permitAll());

        /**
         * @author: sin
         * @Description 授权
         */
        http.authorizeHttpRequests(e -> e.anyRequest().access(authorizationManager));

        /**
         * 配置自定义登录
         */
        http.formLogin(e -> e.loginPage(URLConstant.LOGIN_URL).successHandler(new LoginSuccessHandler()).failureHandler(new LoginFailHandler()));
        http.logout(e -> e.logoutUrl(URLConstant.LOGOUT_URL).logoutSuccessHandler((request, response, authentication) -> {
                    ServletUtils.renderString(response, BaseResponse.success("退出成功"));
                })
        );

        // 配置身份验证异常处理
        http.exceptionHandling(e -> e.authenticationEntryPoint(new NoAuthenticationEntryPoint()));

        // 验证码拦截器
        //http.addFilterBefore(new VerifyCodeFilter(), UsernamePasswordAuthenticationFilter.class);

        // jwt拦截器
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // 跨域漏洞防御 关闭
        http.csrf(e -> e.disable());

        // 跨域拦截 关闭
        http.cors(e -> e.disable());

        return http.build();
    }

    ;

    /**
     * 强散列哈希加密实现
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return SingletonRegistry.getInstance().getPasswordEncoder();
    }

}