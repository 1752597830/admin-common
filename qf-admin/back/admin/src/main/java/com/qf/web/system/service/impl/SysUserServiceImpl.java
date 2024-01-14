package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.common.util.SecurityUtils;
import com.qf.web.system.domain.entity.SysUser;
import com.qf.web.system.domain.vo.UserInfoVo;
import com.qf.web.system.mapper.SysUserMapper;
import com.qf.web.system.service.SysPermissionService;
import com.qf.web.system.service.SysRoleService;
import com.qf.web.system.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Resource
    SysRoleService sysRoleService;

    @Resource
    SysPermissionService sysPermissionService;

    /**
    * @description 根据用户名查询用户信息
    * @param username 用户名
    * @return com.qf.web.system.domain.entity.SysUser
    */
    @Override
    public SysUser selectByUsername(String username) {
        SysUser user = sysUserMapper.selectByUsername(username);
        // 通过id获取权限和角色
        if (user!= null) {
            List<String> roles = sysRoleService.selectRoleByUserId(user.getId());
            List<String> perms = sysPermissionService.selectPermsByUserId(user.getId());
            user.setRoles(roles);
            user.setPerms(perms);
        }
        return user;
    }

    @Override
    public UserInfoVo getUserInfo() {
        SysUser userInfo = SecurityUtils.getUserInfo();
        UserInfoVo user = new UserInfoVo();
        if (userInfo != null) {
            user.setUserId(userInfo.getId());
            user.setUsername(userInfo.getUsername());
            user.setNickname(userInfo.getNickname());
            user.setAvatar(userInfo.getAvatar());
            user.setEmail(userInfo.getEmail());
            user.setMobile(userInfo.getMobile());
            user.setGender(userInfo.getGender());
            user.setContent(userInfo.getContent());
            user.setCreateTime(userInfo.getCreateTime());
            user.setRoles(userInfo.getRoles());
            user.setPerms(userInfo.getPerms());
        }
        return user;
    }
}




