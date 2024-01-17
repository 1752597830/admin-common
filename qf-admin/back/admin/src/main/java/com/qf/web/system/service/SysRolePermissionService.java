package com.qf.web.system.service;

import com.qf.web.system.domain.entity.SysRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_role_permission(角色权限关联表)】的数据库操作Service
* @createDate 2024-01-14 15:48:48
*/
public interface SysRolePermissionService extends IService<SysRolePermission> {

    void deleteByRoleId(Long roleId);

    void insert(List<SysRolePermission> btnList);
}
