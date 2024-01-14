package com.qf.filter;

import com.qf.common.constant.URLConstant;
import com.qf.common.util.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author : sin
 * @date : 2024/1/14 17:01
 * @Description : JWT 拦截器
 */
@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Value("${token.header}")
    private String header;

    @Value("${token.prefix")
    private String tokenPrefix;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 判断url是否匿名访问
        String requestURI = request.getServletPath();
        log.info("JWT请求地址：{}", requestURI);
        //非匿名地址需要校验token
        if (!ToolUtils.contains(requestURI, URLConstant.URLS)) {
            // 获取JWT
            String token = request.getHeader(header);
            int prefixLength = tokenPrefix.length();
            //log.info("接收到的token:{}",token);
            // 前prefixLength位是token前缀
            if (token == null || token.length() < prefixLength + 1) {
                ServletUtils.renderString(response, BaseResponse.fail(ResponseCode.NO_LOGIN.getCode(), ResponseCode.NO_LOGIN.getMsg()));
                return;
            }
            try {
                String token1 = token.substring(prefixLength + 1);
                jwtUtil.tokenVerify(token1);
            } catch (Exception e) {
                ServletUtils.renderString(response, BaseResponse.fail(ResponseCode.NO_LOGIN.getCode(), ResponseCode.NO_LOGIN.getMsg()));
                return;
            }
            log.info("校验成功");
        }
        filterChain.doFilter(request, response);
    }
}