package com.qf.security.handler;

import com.qf.common.util.BaseResponse;
import com.qf.common.util.BeanUtils;
import com.qf.common.util.JwtUtil;
import com.qf.common.util.ServletUtils;
import com.qf.web.system.domain.entity.SysUser;
import com.qf.web.system.domain.vo.LoginResultVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

/**
 * @author : sin
 * @date : 2024/1/14 16:36
 * @Description : 自定义登录成功响应
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
            Environment bean = BeanUtils.getBean(Environment.class);
            String prefix = bean.getProperty("token.prefix");
            Long expireTime = Long.valueOf(bean.getProperty("token.expireTime"));
            String token = BeanUtils.getBean(JwtUtil.class).token(authentication);
            // 通过响应流封装数据返回给前端
            ServletUtils.renderString(response, BaseResponse.success(new LoginResultVo(token,prefix,null,expireTime)));
        }
    }
}