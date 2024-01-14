package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.system.domain.entity.SysRole;
import com.qf.web.system.service.SysPermissionService;
import com.qf.web.system.service.SysRoleService;
import com.qf.web.system.mapper.SysRoleMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_role(角色表)】的数据库操作Service实现
* @createDate 2024-01-14 15:48:48
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
    implements SysRoleService{

    @Resource
    SysRoleMapper sysRoleMapper;
    @Resource
    SysPermissionService sysPermissionService;
    @Override
    public List<String> selectRoleByUserId(Long uid) {
        return sysRoleMapper.selectRoleByUserId(uid);
    }
}




