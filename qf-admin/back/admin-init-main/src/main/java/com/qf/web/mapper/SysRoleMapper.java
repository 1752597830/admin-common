package com.qf.web.mapper;

import com.qf.web.domain.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.web.domain.dto.OptionsDto;
import com.qf.web.domain.vo.RoleForm;
import com.qf.web.domain.vo.RolePageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_role(角色表)】的数据库操作Mapper
* @createDate 2023-12-15 17:27:31
* @Entity com.qf.web.domain.entity.SysRole
*/
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<String> selectRoleByUserId(Long uid);

    List<OptionsDto> getRoleOptions();

    List<Long> selectRoleIdByUserId(Long userId);

    List<RolePageVo> getPage(String keywords);

    RoleForm getRoleById(Long roleId);

    List<Long> selectMenuIdsByRoleId(Long roleId);
}




