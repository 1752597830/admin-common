package com.qf.security.serviceImpl;

import com.qf.web.system.domain.entity.SysUser;
import com.qf.web.system.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author : sin
 * @date : 2024/1/14 12:10
 * @Description : 用户登录实现类
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Resource
    SysUserService sysUserService;

    /**
     * 通过用户名查询用户信息
     * @param username
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserService.selectByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }
}