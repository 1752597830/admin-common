package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.system.domain.dto.RolePageDto;
import com.qf.web.system.domain.entity.SysRole;
import com.qf.web.system.domain.form.RoleForm;
import com.qf.web.system.domain.vo.OptionsVo;
import com.qf.web.system.domain.vo.RolePageVo;
import com.qf.web.system.domain.vo.RoleVo;
import com.qf.web.system.mapper.SysRoleMapper;
import com.qf.web.system.service.SysPermissionService;
import com.qf.web.system.service.SysRoleService;
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
    SysPermissionService permission;

    /**
     * @author: sin
     * @Description 根据用户id获取角色
     * @param uid 用户id
     * @return
     */
    @Override
    public List<String> selectRoleByUserId(Long uid) {
        return sysRoleMapper.selectRoleByUserId(uid);
    }

    /**
     * @author: sin
     * @Description 根据角色名称、角色code、角色状态获取角色分页数据
     */
    @Override
    public List<RolePageVo> getPage(RolePageDto rolePage) {
        return sysRoleMapper.getPage(rolePage.getName(), rolePage.getCode(), rolePage.getStatus());
    }

    /**
     * @description 封装角色下拉选项
     * @return
     */
    @Override
    public List<OptionsVo> getRoleOptions() {
        List<OptionsVo> optionsVos = sysRoleMapper.getRoleOptions();
        return optionsVos;
    }

    /**
     * @description 根据roleId获取角色信息
     * @param roleId
     * @return
     */
    @Override
    public RoleVo getRoleById(Long roleId) {
        return sysRoleMapper.getRoleById(roleId);
    }

    /**
     * @description 根据角色id获取角色的权限
     * @param roleId
     * @return
     */
    @Override
    public List<Long> selectPermByRoleId(Long roleId) {
        List<Long> menuIds = sysRoleMapper.selectPermByRoleId(roleId);
        List<Long> btnIds = permission.selectPermByRoleId(roleId);
        menuIds.addAll(btnIds);
        return menuIds;
    }

    @Override
    public int saveRole(RoleForm roleForm) {
        int row = sysRoleMapper.saveRole(roleForm.getName(), roleForm.getCode(), roleForm.getRemark());
        return row;
    }
}




