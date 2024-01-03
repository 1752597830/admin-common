package com.qf.web.controller;

import com.qf.common.core.controller.BaseController;
import com.qf.common.core.page.PageResult;
import com.qf.common.utils.BaseResponse;
import com.qf.web.domain.dto.RolePage;
import com.qf.web.domain.dto.OptionsDto;
import com.qf.web.domain.vo.RoleForm;
import com.qf.web.domain.vo.RolePageVo;
import com.qf.web.service.SysRoleService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : sin
 * @date : 2023/12/16 17:47
 * @Description : 角色控制器
 */
@RestController
@RequestMapping("/roles")
@Tag(name = "角色管理")
public class SysRoleController extends BaseController {

    @Resource
    private SysRoleService sysRoleService;

    /**
     * 获取角色选项
     */
    @GetMapping("/options")
    public BaseResponse RoleOptions(){

        List<OptionsDto> optionsVos = sysRoleService.getRoleOptions();
        return BaseResponse.success(optionsVos);
    }

    /**
     * 获取分页角色
     */
    @Schema(title = "获取分页角色")
    @GetMapping("/page")
    public BaseResponse getPage(RolePage rolePage) {
        startPage();
        List<RolePageVo> rolePageVos = sysRoleService.getPage(rolePage.getKeywords());
        PageResult pageResult = getData(rolePageVos);
        return BaseResponse.success(pageResult);
    }

    /**
     * roleId获取角色信息
     */
    @GetMapping("/{roleId}/form")
    public BaseResponse getRoleByRoleId(@Parameter(description = "角色ID") @PathVariable Long roleId) {
        RoleForm role = sysRoleService.getRoleById(roleId);
        return BaseResponse.success(role);
    }

    /**
     * 根据roleId获取用户拥有的menuId
     */
    @GetMapping("/{roleId}/menuIds")
    public BaseResponse getMenuIdsByRoleId(@Parameter(description = "角色ID") @PathVariable Long roleId) {
        List<Long> menuIds = sysRoleService.selectMenuIdsByRoleId(roleId);
        return BaseResponse.success(menuIds);
    }

}