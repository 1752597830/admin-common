package com.qf.web.mapper;

import com.qf.web.domain.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.web.domain.vo.MenuOptions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_permission(权限表)】的数据库操作Mapper
* @createDate 2023-12-15 17:25:35
* @Entity com.qf.web.domain.entity.SysPermission
*/
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<String> selectPermsByUserId(Long uid);

    List<MenuOptions> getBtnOptions();

    List<Long> selectBtnIdsByRoleId(Long roleId);
}




