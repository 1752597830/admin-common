package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.system.domain.entity.SysRolePermission;
import com.qf.web.system.service.SysRolePermissionService;
import com.qf.web.system.mapper.SysRolePermissionMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_role_permission(角色权限关联表)】的数据库操作Service实现
* @createDate 2024-01-14 15:48:48
*/
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission>
    implements SysRolePermissionService{

    @Resource
    SysRolePermissionMapper rolePermissionMapper;

    /**
    * @description 根据roleId删除角色权限关联表
    * @param roleId
    */
    @Override
    public void deleteByRoleId(Long roleId) {
        rolePermissionMapper.deleteByRoleId(roleId);
    }

    /**
    * @description 根据roleId和btnList新增角色权限关联表
    * @param btnList
    */
    @Override
    @Transactional
    public void insert(List<SysRolePermission> btnList) {
        rolePermissionMapper.batchInsert(btnList);
    }
}




