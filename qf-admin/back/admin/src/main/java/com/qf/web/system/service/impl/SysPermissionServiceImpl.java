package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.system.domain.entity.SysPermission;
import com.qf.web.system.service.SysPermissionService;
import com.qf.web.system.mapper.SysPermissionMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_permission(权限表)】的数据库操作Service实现
* @createDate 2024-01-14 15:48:48
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
}




