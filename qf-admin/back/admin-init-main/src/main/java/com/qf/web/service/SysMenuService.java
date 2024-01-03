package com.qf.web.service;

import com.qf.web.domain.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.web.domain.dto.MenuOptionsDto;
import com.qf.web.domain.vo.RouteVo;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_menu(菜单管理)】的数据库操作Service
* @createDate 2023-12-15 17:25:35
*/
public interface SysMenuService extends IService<SysMenu> {

    List<RouteVo> getRoutes();

    List<MenuOptionsDto> getMenuOptions();
}
