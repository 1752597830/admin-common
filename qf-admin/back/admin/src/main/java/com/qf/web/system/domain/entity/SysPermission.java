package com.qf.web.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.qf.common.BaseEntity;
import lombok.Data;

/**
 * 权限表
 * @TableName sys_permission
 */
@TableName(value ="sys_permission")
@Data
public class SysPermission extends BaseEntity {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 权限名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 菜单模块ID
     */
    @TableField(value = "menu_id")
    private Integer menuId;

    /**
     * URL权限标识
     */
    @TableField(value = "url_perm")
    private String urlPerm;

    /**
     * 按钮权限标识
     */
    @TableField(value = "btn_perm")
    private String btnPerm;
}