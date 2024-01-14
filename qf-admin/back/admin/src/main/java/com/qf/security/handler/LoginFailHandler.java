package com.qf.security.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import com.qf.common.util.BaseResponse;
import com.qf.common.util.ServletUtils;
import java.io.IOException;

/**
 * @author : sin
 * @date : 2024/1/14 16:37
 * @Description : 登录失败响应
 */
@Slf4j
public class LoginFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        String  result;
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException || e instanceof AuthenticationServiceException) {
            result = e.getMessage();
        } else if (e instanceof LockedException) {
            result = "账户被锁定，请联系管理员!";
        } else if (e instanceof CredentialsExpiredException) {
            result = "证书过期，请联系管理员!";
        } else if (e instanceof AccountExpiredException) {
            result = "账户过期，请联系管理员!";
        } else if (e instanceof DisabledException) {
            result = "账户被禁用，请联系管理员!";
        } else {
            result = "登录失败!";
        }
        log.info("登录失败!");
        ServletUtils.renderString(response, BaseResponse.fail(result));
    }
}