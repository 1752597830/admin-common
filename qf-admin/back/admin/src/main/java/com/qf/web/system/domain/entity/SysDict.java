package com.qf.web.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 字典数据表
 * @TableName sys_dict
 */
@TableName(value ="sys_dict")
@Data
public class SysDict implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 字典类型编码
     */
    @TableField(value = "type_code")
    private String typeCode;

    /**
     * 字典项名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 字典项值
     */
    @TableField(value = "value")
    private String value;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 状态(1:正常;0:禁用)
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 是否默认(1:是;0:否)
     */
    @TableField(value = "defaulted")
    private Integer defaulted;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 创建者
     */
    @TableField(value = "create_by")
    private String createBy;

    /**
     * 更新者
     */
    @TableField(value = "update_by")
    private String updateBy;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}