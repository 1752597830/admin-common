package com.qf.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.domain.entity.SysRole;
import com.qf.web.domain.dto.OptionsDto;
import com.qf.web.domain.vo.RoleForm;
import com.qf.web.domain.vo.RolePageVo;
import com.qf.web.service.SysPermissionService;
import com.qf.web.service.SysRoleService;
import com.qf.web.mapper.SysRoleMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 清风
 * @description 针对表【sys_role(角色表)】的数据库操作Service实现
 * @createDate 2023-12-15 17:27:31
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
        implements SysRoleService {

    @Resource
    SysRoleMapper sysRoleMapper;

    @Resource
    SysPermissionService sysPermissionService;

    @Override
    public List<String> selectRoleByUserId(Long uid) {
        return sysRoleMapper.selectRoleByUserId(uid);
    }

    @Override
    public List<OptionsDto> getRoleOptions() {
        List<OptionsDto> optionsVos = sysRoleMapper.getRoleOptions();
        return optionsVos;
    }

    @Override
    public List<Long> selectRoleIdByUserId(Long userId) {
        return sysRoleMapper.selectRoleIdByUserId(userId);
    }

    @Override
    public List<RolePageVo> getPage(String keywords) {
        return sysRoleMapper.getPage(keywords);
    }

    @Override
    public RoleForm getRoleById(Long roleId) {
        return sysRoleMapper.getRoleById(roleId);
    }

    @Override
    public List<Long> selectMenuIdsByRoleId(Long roleId) {
        List<Long> menuIds = sysRoleMapper.selectMenuIdsByRoleId(roleId);
        List<Long> btnIds = sysPermissionService.selectBtnIdsByRoleId(roleId);
        menuIds.addAll(btnIds);
        return menuIds;
    }
}




