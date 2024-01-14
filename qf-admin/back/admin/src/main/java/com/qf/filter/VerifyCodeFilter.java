package com.qf.filter;

import com.qf.common.constant.CaptchaConstant;
import com.qf.common.constant.RedisConstant;
import com.qf.common.constant.URLConstant;
import com.qf.common.util.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

/**
 * @author : sin
 * @date : 2024/1/14 17:58
 * @Description : 图片验证码拦截器
 */
@Component
@Slf4j
public class VerifyCodeFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        if ("POST".equalsIgnoreCase(request.getMethod()) && URLConstant.LOGIN_URL.equals(request.getServletPath())) {
            String captchaKey = request.getParameter(CaptchaConstant.CAPTCHA_KEY);
            String captchaCode = request.getParameter(CaptchaConstant.CAPTCHA_CODE);
            // TODO 验证码校验 与redis数据比较
            if (StringUtils.isEmpty(captchaCode) || StringUtils.isEmpty(captchaKey) || !captchaCode.equals(BeanUtils.getBean(RedisCache.class).getCacheObject(RedisConstant.REDIS_CAPTCHA_PREFIX + captchaKey))) {
                ServletUtils.renderString(response, BaseResponse.fail(ResponseCode.VERIFY_CODE_ERROR.getCode(), ResponseCode.VERIFY_CODE_ERROR.getMsg()));
                return;
            }
        }
        chain.doFilter(request, response);
    }
}