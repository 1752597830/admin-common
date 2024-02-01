package com.qf.web.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.web.system.domain.entity.SysMenu;
import com.qf.web.system.domain.form.MenuForm;
import com.qf.web.system.domain.vo.MenuOptionsVo;
import com.qf.web.system.domain.vo.MenuTreeVo;
import com.qf.web.system.domain.vo.RouteVo;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_menu(菜单管理)】的数据库操作Service
* @createDate 2024-01-16 14:25:44
*/
public interface SysMenuService extends IService<SysMenu> {

    List<RouteVo> getRoutes();

    List<MenuOptionsVo> getMenuOptions();

    List<MenuTreeVo> getMenuTree();

    List<Long> getMenuIds();

    MenuForm getMenuById(Long id);
}
