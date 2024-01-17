package com.qf.web.system.controller;

import com.qf.common.core.controller.BaseController;
import com.qf.common.core.page.PageResult;
import com.qf.common.util.BaseResponse;
import com.qf.web.system.domain.dto.RolePageDto;
import com.qf.web.system.domain.form.RoleForm;
import com.qf.web.system.domain.vo.OptionsVo;
import com.qf.web.system.domain.vo.RolePageVo;
import com.qf.web.system.domain.vo.RoleVo;
import com.qf.web.system.service.SysRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : sin
 * @date : 2024/1/16 16:42
 * @Description : 角色管理
 */
@Tag(name = "04.角色接口")
@RestController
@RequestMapping("/roles")
@Slf4j
public class RoleController extends BaseController {

    @Resource
    private SysRoleService roleService;

    @Operation(summary = "新增角色")
    @PostMapping("/save")
    public BaseResponse saveRole(@RequestBody RoleForm roleForm){
        int row = roleService.saveRole(roleForm);
        return isOk(row);
    }

    @Operation(summary = "获取角色分页数据",description = "根据角色名称、角色code值获取")
    @GetMapping("/page")
    public BaseResponse getRolePage(@RequestBody RolePageDto rolePage){
        startPage();
        List<RolePageVo> rolePageVos = roleService.getPage(rolePage);
        PageResult pageResult = getData(rolePageVos);
        return BaseResponse.success(pageResult);
    }

    @Operation(summary = "获取角色下拉选项表")
    @GetMapping("/options")
    public BaseResponse RoleOptions(){
        List<OptionsVo> optionsVos = roleService.getRoleOptions();
        return BaseResponse.success(optionsVos);
    }

    @Operation(summary = "获取角色信息",description = "根据roleId获取角色信息")
    @GetMapping("/{roleId}/form")
    public BaseResponse getRoleByRoleId(@Parameter(description = "角色ID") @PathVariable Long roleId) {
        RoleVo role = roleService.getRoleById(roleId);
        return BaseResponse.success(role);
    }

    @Operation(summary = "获取用户拥有的权限",description = "根据roleId获取用户拥有的权限")
    @GetMapping("/{roleId}/perms")
    public BaseResponse getRolePerms(@Parameter(description = "角色ID") @PathVariable Long roleId) {
        List<Long> perms = roleService.selectPermByRoleId(roleId);
        return BaseResponse.success(perms);
    }

    @Operation(summary = "修改角色信息",description = "根据roleId修改角色信息")
    @PutMapping("/{id}")
    public BaseResponse updateRole(@PathVariable Long id,@RequestBody RoleForm roleForm){
        int row = roleService.updateRoleById(id,roleForm);
        return isOk(row);
    }

    @Operation(summary = "删除角色",description = "根据roleId删除对应角色,逻辑删除 is_deleted=1")
    @DeleteMapping("/{roleId}")
    public BaseResponse deleteRole(@PathVariable Long roleId){
        int row = roleService.deleteRoleById(roleId);
        return isOk(row);
    }

    @Operation(summary = "修改角色权限",description = "根据roleId修改角色权限,修改role_permission表中字段")
    @PutMapping("/{roleId}/{ids}")
    public BaseResponse updateRolePerm(@PathVariable Long roleId,@PathVariable String ids){
        int row = roleService.updateRolePermById(roleId,ids);
        return isOk(row);
    }
}