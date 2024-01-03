package com.qf.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.domain.entity.SysPermission;
import com.qf.web.domain.vo.MenuOptions;
import com.qf.web.service.SysPermissionService;
import com.qf.web.mapper.SysPermissionMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_permission(权限表)】的数据库操作Service实现
* @createDate 2023-12-15 17:25:35
*/
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission>
    implements SysPermissionService{

    @Resource
    SysPermissionMapper sysPermissionMapper;

    @Override
    public List<String> selectPermsByUserId(Long uid) {
        return sysPermissionMapper.selectPermsByUserId(uid);
    }

    @Override
    public List<SysPermission> selectAll() {
        return sysPermissionMapper.selectList(null);
    }

    @Override
    public List<MenuOptions> getBtnOptions() {
        return sysPermissionMapper.getBtnOptions();
    }

    @Override
    public List<Long> selectBtnIdsByRoleId(Long roleId) {
        return sysPermissionMapper.selectBtnIdsByRoleId(roleId);
    }
}




