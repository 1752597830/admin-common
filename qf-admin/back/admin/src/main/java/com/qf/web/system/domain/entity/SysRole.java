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
 * 角色表
 * @TableName sys_role
 */
@TableName(value ="sys_role")
@Data
public class SysRole  extends BaseEntity {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 角色编码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 显示顺序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 角色状态(1-正常；0-停用)
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 逻辑删除标识(0-未删除；1-已删除)
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;
}