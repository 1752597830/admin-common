package com.qf.web.controller;

import com.qf.common.utils.BaseResponse;
import com.qf.web.domain.dto.MenuOptionsDto;
import com.qf.web.domain.vo.RouteVo;
import com.qf.web.service.SysMenuService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : sin
 * @date : 2023/12/15 19:08
 * @Description :
 */
@RestController
@RequestMapping("/menus")
@Tag(name = "03.菜单接口")
public class SysMenuController {

    @Resource
    SysMenuService sysMenuService;

    /**
     * 获取路由信息
     */
    @Schema(title = "获取路由")
    @GetMapping("/routes")
    public BaseResponse getRoutes() {

        List<RouteVo> routes = sysMenuService.getRoutes();
        return BaseResponse.success(routes);
    }

    /**
     * 获取权限树
     */
    @Schema(title = "获取权限树")
    @GetMapping("/options")
    public BaseResponse getPerms() {
        List<MenuOptionsDto> sysMenus = sysMenuService.getMenuOptions();
        return BaseResponse.success(sysMenus);
    }

}