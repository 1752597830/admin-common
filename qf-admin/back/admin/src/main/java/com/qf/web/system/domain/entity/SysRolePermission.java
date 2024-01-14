package com.qf.web.system.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色权限关联表
 * @TableName sys_role_permission
 */
@TableName(value ="sys_role_permission")
@Data
@AllArgsConstructor
public class SysRolePermission implements Serializable {
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 访问权限ID
     */
    private Long permissionId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}