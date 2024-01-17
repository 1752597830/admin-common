package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.system.domain.entity.SysRoleMenu;
import com.qf.web.system.mapper.SysRoleMenuMapper;
import com.qf.web.system.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_role_menu(角色和菜单关联表)】的数据库操作Service实现
* @createDate 2024-01-16 14:25:44
*/
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu>
    implements SysRoleMenuService{

    /**
    * @description 根据角色ID删除角色和菜单关联表的所有数据
    * @param roleId 角色ID
    * @return int
    */
    @Override
    public int deleteByRoleId(Long roleId) {
        try {
            return baseMapper.deleteByRoleId(roleId);
        } catch (Exception e) {
            log.error("根据角色ID删除角色和菜单关联表的所有数据失败", e);
        }
        return 1;
    }

    /**
    * @description 根据角色ID和菜单ID列表插入角色和菜单关联表
    * @param menuList 菜单ID列表
    * @return int
    */
    @Override
    public int insert(List<SysRoleMenu> menuList)  {
        return baseMapper.batchInsertRoleMenus(menuList);
    }
}




