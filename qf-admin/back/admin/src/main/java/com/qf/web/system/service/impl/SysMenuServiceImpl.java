package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.common.enmu.MenuEnum;
import com.qf.common.util.SecurityUtils;
import com.qf.web.system.domain.entity.SysMenu;
import com.qf.web.system.domain.entity.SysPermission;
import com.qf.web.system.domain.entity.SysUser;
import com.qf.web.system.domain.form.MenuForm;
import com.qf.web.system.domain.vo.MenuOptions;
import com.qf.web.system.domain.vo.MenuOptionsVo;
import com.qf.web.system.domain.vo.MenuTreeVo;
import com.qf.web.system.domain.vo.RouteVo;
import com.qf.web.system.mapper.SysMenuMapper;
import com.qf.web.system.service.SysMenuService;
import com.qf.web.system.service.SysPermissionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author 清风
* @description 针对表【sys_menu(菜单管理)】的数据库操作Service实现
* @createDate 2024-01-16 14:25:44
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService{

    @Resource
    private SysMenuMapper menuMapper;

    @Resource
    private SysPermissionService permissionService;

    /**
     * @author: sin
     * @Description  获取路由
     */
    @Override
    public List<RouteVo> getRoutes() {
        SysUser userInfo = SecurityUtils.getUserInfo();
        if (userInfo == null) {
            return null;
        }
        List<SysMenu> menus = menuMapper.getMenus(userInfo.getId());
        List<RouteVo> routeVos = buildRoutesTree(menus, 0L, userInfo.getRoles());
        return routeVos;
    }

    public List<MenuOptionsVo> getMenuOptions() {
        List<MenuOptions> menuOptions = menuMapper.getMenuOptions();
        List<MenuOptions> btnOptions = permissionService.getBtnOptions();
        return menuOptions == null || menuOptions.size() == 0 ? null : buildOptionsTree(menuOptions.addAll(btnOptions) ? menuOptions : null, 0L);
    }

    @Override
    public List<MenuTreeVo> getMenuTree() {
        List<SysMenu> menus = menuMapper.selectList(null);
        List<SysPermission> permissions = permissionService.selectAll();
        List<MenuTreeVo> list = buildMenuTree(menus, permissions, 0L);
        return list;
    }

    /**
     * @author: sin
     * @Description  获取所有菜单id
     */
    @Override
    public List<Long> getMenuIds() {
        return menuMapper.getMenuIds();
    }

    @Override
    public MenuForm getMenuById(Long id) {

        MenuForm menuForm = new MenuForm();
        if(id < 1000) {
            SysMenu menu = menuMapper.getMenuById(id);
            menuForm.setParentId(menu.getParentId());
            menuForm.setName(menu.getName());
            menuForm.setType(MenuEnum.enumMap.get(menu.getType()));
            menuForm.setIcon(menu.getIcon());
            menuForm.setPath(menu.getPath());
            menuForm.setSort(menu.getSort());
            menuForm.setVisible(menu.getVisible());
            menuForm.setComponent(menu.getComponent());
            menuForm.setRedirect(menu.getRedirect());
        } else {
            menuForm = permissionService.getPermsById(id);
        }
        return menuForm;
    }

    /**
     * @author: sin
     * @Description  构建菜单树
     */
    private List<MenuTreeVo> buildMenuTree(List<SysMenu> menus, List<SysPermission> permissions, long parentId) {
        List<MenuTreeVo> list = new ArrayList<>();
        List<SysMenu> menusList = menus.stream().filter(menu -> menu.getParentId() != parentId).collect(Collectors.toList());
        menus.stream().filter(menu -> menu.getParentId().equals(parentId)).forEach(menu -> {
            MenuTreeVo menuTreeVo = new MenuTreeVo(menu.getId(), menu.getParentId(), menu.getName(), MenuEnum.enumMap.get(menu.getType()), menu.getPath(), menu.getComponent(), menu.getIcon(), menu.getSort(), menu.getVisible(), null, menu.getRedirect(), buildMenuTree(menusList, permissions, menu.getId()));
            list.add(menuTreeVo);
            permissions.forEach(sysPermission -> {
                if(sysPermission.getMenuId() == menu.getId()) {
                    menuTreeVo.getChildren().add(new MenuTreeVo(sysPermission.getId(), sysPermission.getMenuId(), sysPermission.getName(), MenuEnum.enumMap.get(3), sysPermission.getUrlPerm(), null, "", null, 1, sysPermission.getBtnPerm(), null, null));
                }
            });
        });

        return list;
    }

    /**
     * 构建路由树
     */
    public List<RouteVo> buildRoutesTree(List<SysMenu> menus, Long parentId, List<String> roles) {
        List<RouteVo> list = new ArrayList<>();
        List<SysMenu> menusList = menus.stream().filter(menu -> menu.getParentId() != parentId).collect(Collectors.toList());
        menus.stream().filter(menu -> menu.getParentId().equals(parentId)).forEach(menu -> {

            String name = menu.getPath() != null && menu.getPath().length() > 0 ? menu.getPath().substring(0, 1).toUpperCase() + menu.getPath().substring(1) : menu.getName();

            RouteVo routeVo = new RouteVo(menu.getId(), menu.getPath(), menu.getComponent(), menu.getRedirect(), name, new RouteVo.Meta(menu.getName(), menu.getIcon(), menu.getVisible() == 0 ? true : false, roles, true), buildRoutesTree(menusList, menu.getId(), roles));
            list.add(routeVo);
        });
        return list;
    }

    public List<MenuOptionsVo> buildOptionsTree(List<MenuOptions> menusOptions, Long parentId) {
        List<MenuOptionsVo> list = new ArrayList<>();

        // 取出树的下一层菜单
        List<MenuOptions> menusList = menusOptions.stream().filter(menu -> menu.getParentId() != parentId).collect(Collectors.toList());
        // parentId相同的进行构建
        menusOptions.stream().filter(menu -> menu.getParentId().equals(parentId)).forEach(menu -> {
            MenuOptionsVo dto = new MenuOptionsVo(menu.getValue(), menu.getLabel(), buildOptionsTree(menusList, menu.getValue()));
            list.add(dto);
        });
        return list;
    }
}




