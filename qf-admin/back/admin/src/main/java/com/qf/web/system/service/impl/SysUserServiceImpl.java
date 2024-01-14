package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.system.domain.entity.SysUser;
import com.qf.web.system.service.SysUserService;
import com.qf.web.system.mapper.SysUserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author 清风
* @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
* @createDate 2024-01-14 11:23:53
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

    @Resource
    SysUserMapper sysUserMapper;

    /**
    * @description 根据用户名查询用户信息
    * @param username 用户名
    * @return com.qf.web.system.domain.entity.SysUser
    */
    @Override
    public SysUser selectByUsername(String username) {
        SysUser user = sysUserMapper.selectByUsername(username);
        return user;
    }
}




