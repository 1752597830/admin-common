package com.qf.web.system.service;

import com.qf.web.system.domain.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.web.system.domain.dto.RolePageDto;
import com.qf.web.system.domain.form.RoleForm;
import com.qf.web.system.domain.vo.OptionsVo;
import com.qf.web.system.domain.vo.RolePageVo;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_role(角色表)】的数据库操作Service
* @createDate 2024-01-14 15:48:48
*/
public interface SysRoleService extends IService<SysRole> {

    List<String> selectRoleByUserId(Long id);

    List<RolePageVo> getPage(RolePageDto rolePage);

    List<OptionsVo> getRoleOptions();

    RoleForm getRoleById(Long roleId);

    List<Long> selectPermByRoleId(Long roleId);
}
