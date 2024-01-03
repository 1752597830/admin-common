package com.qf.web.mapper;

import com.qf.web.domain.dto.MenuOptionsDto;
import com.qf.web.domain.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.web.domain.vo.MenuOptions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_menu(菜单管理)】的数据库操作Mapper
* @createDate 2023-12-15 17:25:35
* @Entity com.qf.web.domain.entity.SysMenu
*/
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getMenus(Long uid);

    List<MenuOptions> getMenuOptions();
}




