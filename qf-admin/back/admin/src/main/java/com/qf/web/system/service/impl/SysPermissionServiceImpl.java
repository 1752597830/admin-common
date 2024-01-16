package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.system.domain.entity.SysPermission;
import com.qf.web.system.domain.vo.MenuOptions;
import com.qf.web.system.mapper.SysPermissionMapper;
import com.qf.web.system.service.SysPermissionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_permission(权限表)】的数据库操作Service实现
* @createDate 2024-01-14 15:48:48
*/
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission>
    implements SysPermissionService{

    @Resource
    SysPermissionMapper permissionMapper;

    @Override
    public List<String> selectPermsByUserId(Long uid) {
        return permissionMapper.selectPermsByUserId(uid);
    }

    /**
    * @description 获取所有按钮权限
    * @return java.util.List<com.qf.web.system.domain.entity.SysPermission>
    */
    @Override
    public List<SysPermission> selectAll() {
        return permissionMapper.selectList(null);
    }

    /**
    * @description 获取按钮权限
    * @return java.util.List<com.qf.web.system.domain.vo.MenuOptions>
    */
    @Override
    public List<MenuOptions> getBtnOptions() {
        return permissionMapper.getBtnOptions();
    }

    /**
    * @description 获取角色权限
    * @param roleId
    * @return java.util.List<java.lang.Long>
    */
    @Override
    public List<Long> selectPermByRoleId(Long roleId) {
        return permissionMapper.selectPermByRoleId(roleId);
    }
}




