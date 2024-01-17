package com.qf.web.system.service;

import com.qf.web.system.domain.entity.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_role_menu(角色和菜单关联表)】的数据库操作Service
* @createDate 2024-01-16 14:25:44
*/
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    int deleteByRoleId(Long roleId);

    int insert(List<SysRoleMenu> menuList);
}
