package com.qf.web.system.service;

import com.qf.web.system.domain.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_user_role(用户和角色关联表)】的数据库操作Service
* @createDate 2024-01-14 15:48:48
*/
public interface SysUserRoleService extends IService<SysUserRole> {
    int insert(Long userId, Long roleId);

    int updateRoleByUserId(Long userId, Long roleId);

    List<Long> selectRoleIdByUserId(Long userId);
}
