package com.qf.web.system.controller;

import com.qf.common.util.BaseResponse;
import com.qf.web.system.domain.vo.MenuOptionsVo;
import com.qf.web.system.domain.vo.MenuTreeVo;
import com.qf.web.system.domain.vo.RouteVo;
import com.qf.web.system.service.SysMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : sin
 * @date : 2024/1/16 14:27
 * @Description : 菜单控制器
 */
@Tag(name = "03.菜单接口")
@RestController
@RequestMapping("/menus")
@Slf4j
public class MenuController {
    @Resource
    SysMenuService menuService;

    /**
     * 获取路由信息
     */
    @Operation(summary = "获取路由")
    @GetMapping("/routes")
    public BaseResponse getRoutes() {
        List<RouteVo> routes = menuService.getRoutes();
        return BaseResponse.success(routes);
    }

    /**
     * 获取权限树
     */
    @Operation(summary = "获取权限树")
    @GetMapping("/options")
    public BaseResponse getPerms() {
        List<MenuOptionsVo> sysMenus = menuService.getMenuOptions();
        return BaseResponse.success(sysMenus);
    }

    /**
     * @author: sin
     * @Description 获取菜单树
     */
    @Operation(summary = "获取菜单树")
    @GetMapping("")
    public BaseResponse getMenuTree() {
        List<MenuTreeVo> sysMenus = menuService.getMenuTree();
        return BaseResponse.success(sysMenus);
    }

    @Operation(summary ="通过id获取菜单表数据")
    @GetMapping("/{id}/form")
    public BaseResponse getMenuById(@PathVariable Long id) {

        return BaseResponse.success(menuService.getMenuById(id));
    }
}