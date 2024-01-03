package com.qf.web.service;

import com.qf.web.domain.dto.MenuOptionsDto;
import com.qf.web.domain.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.web.domain.vo.MenuOptions;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_permission(权限表)】的数据库操作Service
* @createDate 2023-12-15 17:25:35
*/
public interface SysPermissionService extends IService<SysPermission> {

    List<String> selectPermsByUserId(Long uid);

    List<SysPermission> selectAll();

    List<MenuOptions> getBtnOptions();

    List<Long> selectBtnIdsByRoleId(Long roleId);
}
