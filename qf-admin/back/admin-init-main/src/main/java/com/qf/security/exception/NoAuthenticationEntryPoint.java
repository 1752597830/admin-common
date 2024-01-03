package com.qf.security.exception;

import com.qf.common.utils.BaseResponse;
import com.qf.common.utils.ResponseCode;
import com.qf.common.utils.ServletUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author : sin
 * @date : 2023/11/28 15:05
 * @Description : 认证异常
 */
@Component
@Slf4j
public class NoAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        log.info("认证异常");
        int status = response.getStatus();
        System.out.println(status);
        if (status == HttpServletResponse.SC_NOT_FOUND) {
            // 资源不存在
            ServletUtils.renderString(response, BaseResponse.fail(ResponseCode.NO_EXIST.getCode(), ResponseCode.NO_EXIST.getMsg()));
        } else if (status == HttpServletResponse.SC_FORBIDDEN) {
            // 无权访问
            ServletUtils.renderString(response, BaseResponse.fail(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getMsg()));
        } else {

            ServletUtils.renderString(response, BaseResponse.fail(ResponseCode.NO_LOGIN.getCode(), ResponseCode.NO_LOGIN.getMsg()));
        }
    }
}