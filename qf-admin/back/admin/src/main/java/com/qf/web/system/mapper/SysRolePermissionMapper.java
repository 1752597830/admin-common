package com.qf.web.system.mapper;

import com.qf.web.system.domain.entity.SysRolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_role_permission(角色权限关联表)】的数据库操作Mapper
* @createDate 2024-01-14 15:48:48
* @Entity com.qf.web.system.domain.entity.SysRolePermission
*/
@Mapper
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {

    void deleteByRoleId(Long roleId);

    void batchInsert(List<SysRolePermission> btnList);
}




