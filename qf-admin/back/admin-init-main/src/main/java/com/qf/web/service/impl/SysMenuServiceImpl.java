package com.qf.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.common.utils.SecurityUtils;
import com.qf.web.domain.entity.SysMenu;
import com.qf.web.domain.entity.SysUser;
import com.qf.web.domain.dto.MenuOptionsDto;
import com.qf.web.domain.vo.MenuOptions;
import com.qf.web.domain.vo.RouteVo;
import com.qf.web.domain.vo.RouteVo.Meta;
import com.qf.web.service.SysMenuService;
import com.qf.web.mapper.SysMenuMapper;
import com.qf.web.service.SysPermissionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 清风
 * @description 针对表【sys_menu(菜单管理)】的数据库操作Service实现
 * @createDate 2023-12-15 17:25:35
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
        implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Resource
    private SysPermissionService sysPermissionService;

    @Override
    public List<RouteVo> getRoutes() {
        SysUser userInfo = SecurityUtils.getUserInfo();
        if (userInfo == null) {
            return null;
        }
        List<SysMenu> menus = sysMenuMapper.getMenus(userInfo.getId());
        List<RouteVo> routeVos = buildRoutesTree(menus, 0L, userInfo.getRoles());
        return routeVos;
    }

    @Override
    public List<MenuOptionsDto> getMenuOptions() {
        List<MenuOptions> menuOptions = sysMenuMapper.getMenuOptions();
        List<MenuOptions> btnOptions = sysPermissionService.getBtnOptions();
        return menuOptions == null || menuOptions.size() == 0 ? null : buildOptionsTree(menuOptions.addAll(btnOptions) ? menuOptions : null, 0L);
    }

    /**
     * 构建路由树
     */
    public List<RouteVo> buildRoutesTree(List<SysMenu> menus, Long parentId, List<String> roles) {
        List<RouteVo> list = new ArrayList<>();
        List<SysMenu> menusList = menus.stream().filter(menu -> menu.getParentId() != parentId).collect(Collectors.toList());
        menus.stream().filter(menu -> menu.getParentId().equals(parentId)).forEach(menu -> {

            String name = menu.getPath() != null && menu.getPath().length() > 0 ? menu.getPath().substring(0, 1).toUpperCase() + menu.getPath().substring(1) : menu.getName();

            RouteVo routeVo = new RouteVo(menu.getId(),menu.getPath(), menu.getComponent(), menu.getRedirect(), name, new Meta(menu.getName(), menu.getIcon(), menu.getVisible() == 0 ? true : false, roles, true), buildRoutesTree(menusList, menu.getId(), roles));
            list.add(routeVo);
        });
        return list;
    }

    public List<MenuOptionsDto> buildOptionsTree(List<MenuOptions> menusOptions, Long parentId) {
        List<MenuOptionsDto> list = new ArrayList<>();

        // 取出树的下一层菜单
        List<MenuOptions> menusList = menusOptions.stream().filter(menu -> menu.getParentId() != parentId).collect(Collectors.toList());
        // parentId相同的进行构建
        menusOptions.stream().filter(menu -> menu.getParentId().equals(parentId)).forEach(menu -> {
            MenuOptionsDto dto = new MenuOptionsDto(menu.getValue(), menu.getLabel(), buildOptionsTree(menusList, menu.getValue()));
            list.add(dto);
        });
        return list;
    }
}




