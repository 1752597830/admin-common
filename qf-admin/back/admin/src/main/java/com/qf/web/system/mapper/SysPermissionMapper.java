package com.qf.web.system.mapper;

import com.qf.web.system.domain.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_permission(权限表)】的数据库操作Mapper
* @createDate 2024-01-14 15:48:48
* @Entity com.qf.web.system.domain.entity.SysPermission
*/
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<String> selectPermsByUserId(Long uid);
}




