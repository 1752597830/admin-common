package com.qf.web.service;

import com.qf.web.domain.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.web.domain.dto.OptionsDto;
import com.qf.web.domain.vo.RoleForm;
import com.qf.web.domain.vo.RolePageVo;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_role(角色表)】的数据库操作Service
* @createDate 2023-12-15 17:27:31
*/
public interface SysRoleService extends IService<SysRole> {

    List<String> selectRoleByUserId(Long uid);

    List<OptionsDto> getRoleOptions();

    List<Long> selectRoleIdByUserId(Long userId);

    List<RolePageVo> getPage(String keywords);

    RoleForm getRoleById(Long roleId);

    List<Long> selectMenuIdsByRoleId(Long roleId);
}
