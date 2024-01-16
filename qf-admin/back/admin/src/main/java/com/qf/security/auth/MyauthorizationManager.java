package com.qf.security.auth;

import com.qf.common.constant.URLConstant;
import com.qf.common.util.BeanUtils;
import com.qf.common.util.SecurityUtils;
import com.qf.common.util.ToolUtils;
import com.qf.web.system.domain.entity.SysPermission;
import com.qf.web.system.domain.entity.SysUser;
import com.qf.web.system.service.SysPermissionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author : sin
 * @date : 2024/1/14 20:56
 * @Description : 通过拦截器方式动态实现权限校验
 */
@Slf4j
@Component
public class MyauthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {
    @Override
    public void verify(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        AuthorizationManager.super.verify(authentication, object);
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext requestAuthorizationContext) {
        if (!(authentication.get().getPrincipal() instanceof SysUser)) {
            throw new AccessDeniedException("匿名不可访问!");
        }
        SysUser user = (SysUser) authentication.get().getPrincipal();

        //访问的接口地址
        HttpServletRequest request = requestAuthorizationContext.getRequest();
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        //匿名地址直接访问
        if (ToolUtils.contains(requestURI, URLConstant.URLS)) {
            return new AuthorizationDecision(true);
        }
        //查询当前请求的接口需要哪些权限能访问
        List<SysPermission> permissions = BeanUtils.getBean(SysPermissionService.class).selectAll();
        for (SysPermission permission : permissions) {
            if (SecurityUtils.checkPermission(permission.getUrlPerm(),method + ":" + requestURI)) {
                log.info("权限处理!");
                boolean contains = ToolUtils.contains(permission.getBtnPerm(), user.getPerms().toArray(new String[]{}));
                if (!contains) {
                    throw new AccessDeniedException(user.getUsername()+",没有访问:"+requestURI+"的权限");
                } else {
                    break;
                }
            }
        }
        return new AuthorizationDecision(true);
    }
}