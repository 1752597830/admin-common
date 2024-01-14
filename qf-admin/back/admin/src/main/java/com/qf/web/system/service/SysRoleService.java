package com.qf.web.system.service;

import com.qf.web.system.domain.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_role(角色表)】的数据库操作Service
* @createDate 2024-01-14 15:48:48
*/
public interface SysRoleService extends IService<SysRole> {

    List<String> selectRoleByUserId(Long id);
}
