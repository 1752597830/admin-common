package com.qf.common.util;

import com.qf.common.enmu.ResponseCode;
import com.qf.common.exception.BaseException;
import com.qf.web.system.domain.entity.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author : sin
 * @date : 2024/1/14 20:19
 * @Description :
 */
public class SecurityUtils {
    /**
     * 通过SecurityContextHandler获取当前用户身份令牌
     */
    public static Authentication getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
    /**
     * 通过Authentication获取当前用户信息
     */
    public static SysUser getUserInfo() {
        Authentication authentication = getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof SysUser) {
                SysUser user = (SysUser) authentication.getPrincipal();
                return user;
            }
        }
        throw new BaseException(ResponseCode.NO_LOGIN.getCode(), ResponseCode.NO_LOGIN.getMsg());
    }
    /**
     * 校验权限
     * String m = "DELETE:/api/v1/roles/*";
     * String s1 = "DELETE:/api/v1/roles/1/2";
     * System.out.println(checkPermission(m, s1)); // 输出 true，s1匹配m
     */
    public static boolean checkPermission(String pattern, String target) {
        // 将通配符*替换成正则表达式.*
        String regex = pattern.replaceAll("\\*", ".*");


        // 使用matches方法进行匹配
        return target.matches(regex);
    }

    /**
     * @author: sin
     * @Description 更新SecurityContext中的用户信息
     */
    /**
     * 设置当前登录用户，保存 或 更新登录信息
     *
     * @param userDetails
     */
    //public static void setLoginUser(UserDetails userDetails) {
    //    SecurityContextHolder.getContext().setAuthentication(
    //            new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities()));
    //}

}