package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.common.constant.CommonConstant;
import com.qf.common.enmu.ResponseCode;
import com.qf.common.exception.BaseException;
import com.qf.common.util.ToolUtils;
import com.qf.web.system.domain.dto.RolePageDto;
import com.qf.web.system.domain.entity.SysRole;
import com.qf.web.system.domain.entity.SysRoleMenu;
import com.qf.web.system.domain.entity.SysRolePermission;
import com.qf.web.system.domain.form.RoleForm;
import com.qf.web.system.domain.vo.OptionsVo;
import com.qf.web.system.domain.vo.RolePageVo;
import com.qf.web.system.domain.vo.RoleVo;
import com.qf.web.system.mapper.SysRoleMapper;
import com.qf.web.system.service.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    SysPermissionService permissionService;

    @Resource
    SysRoleMenuService roleMenuService;

    @Resource
    SysRolePermissionService rolePermissionService;

    @Resource
    SysMenuService menuService;

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
        List<Long> btnIds = permissionService.selectPermByRoleId(roleId);
        menuIds.addAll(btnIds);
        return menuIds;
    }

    /**
     * @description 新增角色
     * @param roleForm
     * @return
     */
    @Override
    public int saveRole(RoleForm roleForm) {
        // TODO 需要判断name是否存在  name添加了索引
        int row = sysRoleMapper.saveRole(roleForm.getName(), roleForm.getCode(), roleForm.getRemark());
        return row;
    }

    /**
     * @description 根据角色id修改角色信息
     * @param roleId
     * @param roleForm
     * @return
     */
    @Override
    public int updateRoleById(Long roleId, RoleForm roleForm) {
        int row = sysRoleMapper.updateRoleById(roleId, roleForm.getName(), roleForm.getCode(), roleForm.getRemark());
        return row;
    }

    /**
     * @description 根据角色id删除角色 (逻辑删除 is_deleted=1)
     * @param roleId
     * @return
     */
    @Override
    public int deleteRoleById(Long roleId) {
        int row = sysRoleMapper.deleteRoleById(roleId);
        return row;
    }

    /**
     * @description 根据角色id修改角色权限(权限ids)
     * @param roleId
     * @param ids 封装菜单 按钮id
     * @return
     */
    @Override
    @Transactional
    public int updateRolePermById(Long roleId, String ids) {
        List<Long> listIds = ToolUtils.getLongListByString(ids);
        List<Long> menuList = listIds.stream().filter(id -> id < CommonConstant.MENU_PERMISSION_SPLIT_POINT).toList();
        List<Long> permIds = listIds.stream().filter(id -> id > CommonConstant.MENU_PERMISSION_SPLIT_POINT).toList();

        if(!ToolUtils.isContain( menuService.getMenuIds(),menuList)|| !ToolUtils.isContain(permissionService.getBtnIds(),permIds)) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(),CommonConstant.ILLEGAL_PARAM);
        }

        List<SysRolePermission> rolePermissions = new ArrayList<>();
        List<SysRoleMenu> roleMenus = new ArrayList<>();
        for (Long menuId : menuList) {
            SysRoleMenu roleMenu = new SysRoleMenu(roleId, menuId);
            roleMenus.add(roleMenu);
        }
        for (Long btnId : permIds) {
            SysRolePermission rolePermission = new SysRolePermission(roleId, btnId);
            rolePermissions.add(rolePermission);
        }
        try {
            // 删除role_menu中数据
            roleMenuService.deleteByRoleId(roleId);
            // 插入数据
            if (ToolUtils.isOk(roleMenus.size())) {
                roleMenuService.insert(roleMenus);
            }
            rolePermissionService.deleteByRoleId(roleId);
            if (ToolUtils.isOk(rolePermissions.size())) {
                rolePermissionService.insert(rolePermissions);
            }
        } catch (Exception e) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(),CommonConstant.EDIT + CommonConstant.ROLE + CommonConstant.PERMISSION + CommonConstant.ERROR);
        }
        return 1;
    }
}




