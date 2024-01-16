package com.qf.web.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.web.system.domain.entity.SysMenu;
import com.qf.web.system.domain.vo.MenuOptions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_menu(菜单管理)】的数据库操作Mapper
* @createDate 2024-01-16 14:25:44
* @Entity com.qf.web.system.domain.entity.SysMenu
*/
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getMenus(Long uid);

    List<MenuOptions> getMenuOptions();
}




