package com.qf.common.filter;

import com.qf.common.constant.Constant;
import com.qf.common.utils.*;
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
 * @data : 2023/12/13 13:10
 * @Description :
 */
@Component
@Slf4j
public class VerifyCodeFilter extends GenericFilterBean {


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        log.info("路径是： " + request.getServletPath());
        if ("POST".equalsIgnoreCase(request.getMethod()) && Constant.LOGIN_URL.equals(request.getServletPath())) {
            String captchaKey = request.getParameter(Constant.CAPTCHA_KEY);
            String captchaCode = request.getParameter(Constant.CAPTCHA_CODE);
            if (StringUtils.isEmpty(captchaCode) || !captchaCode.equals(BeanUtils.getBean(RedisCache.class).getCacheObject(Constant.REDIS_CAPTCHA_PREFIX + captchaKey))) {
                ServletUtils.renderString(response, BaseResponse.fail(ResponseCode.VERIFY_CODE_ERROR.getCode(), ResponseCode.VERIFY_CODE_ERROR.getMsg()));
                return;
            }
        }
        chain.doFilter(request, response);
    }
}