package com.qf.web.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.web.system.domain.entity.SysPermission;
import com.qf.web.system.domain.vo.MenuOptions;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_permission(权限表)】的数据库操作Service
* @createDate 2024-01-14 15:48:48
*/
public interface SysPermissionService extends IService<SysPermission> {

    List<String> selectPermsByUserId(Long id);

    List<SysPermission> selectAll();

    List<MenuOptions> getBtnOptions();
}
