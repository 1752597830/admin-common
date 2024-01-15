package com.qf.web.system.mapper;

import com.qf.web.system.domain.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_user_role(用户和角色关联表)】的数据库操作Mapper
* @createDate 2024-01-14 15:48:48
* @Entity com.qf.web.system.domain.entity.SysUserRole
*/
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    Integer updateRoleByUserId(Long userId, Long roleId);

    int addRoleByUserId(Long userId, Long roleId);

    List<Long> selectRoleIdByUserId(Long userId);
}




