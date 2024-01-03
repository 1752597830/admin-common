package com.qf.security.handler;

import com.qf.common.utils.BaseResponse;
import com.qf.common.utils.BeanUtils;
import com.qf.common.utils.JwtUtil;
import com.qf.common.utils.ServletUtils;
import com.qf.web.domain.dto.LoginResult;
import com.qf.web.domain.entity.SysUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : sin
 * @date : 2023/12/13 10:22
 * @Description : 登录成功响应
 */
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("登录成功");
        if (authentication.getPrincipal() instanceof SysUser) {
            SysUser sysUser = (SysUser) authentication.getPrincipal();
            log.info("登录成功，用户信息：{}", sysUser);
            // 获取token  封装
            String token = BeanUtils.getBean(JwtUtil.class).token(authentication);
            ServletUtils.renderString(response, BaseResponse.success(new LoginResult(token, "Bearer", null,null)));
        }
    }
}