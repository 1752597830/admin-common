package com.qf.security.serviceImpl;

import com.qf.web.domain.entity.SysUser;
import com.qf.web.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author : sin
 * @date : 2023/12/13 10:06
 * @Description :
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Resource
    SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserService.selectByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }
}