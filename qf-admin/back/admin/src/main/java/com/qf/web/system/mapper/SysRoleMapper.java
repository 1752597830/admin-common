package com.qf.web.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.web.system.domain.entity.SysRole;
import com.qf.web.system.domain.vo.OptionsVo;
import com.qf.web.system.domain.vo.RolePageVo;
import com.qf.web.system.domain.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_role(角色表)】的数据库操作Mapper
* @createDate 2024-01-14 15:48:48
* @Entity com.qf.web.system.domain.entity.SysRole
*/
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<String> selectRoleByUserId(Long uid);

    List<RolePageVo> getPage(String name, String code, Integer status);

    List<OptionsVo> getRoleOptions();

    RoleVo getRoleById(Long roleId);

    List<Long> selectPermByRoleId(Long roleId);

    int saveRole(String name,String code, String remark);

    int updateRoleById(Long roleId, String name, String code, String remark);

    int deleteRoleById(Long roleId);
}




