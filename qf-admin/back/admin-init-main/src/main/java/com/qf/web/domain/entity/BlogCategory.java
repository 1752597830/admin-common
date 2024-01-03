package com.qf.web.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 分类表
 * @TableName blog_category
 */
@TableName(value ="blog_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogCategory implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 分类名称 唯一
     */
    private String categoryName;

    /**
     * 分类图标
     */
    private String categoryIcon;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public BlogCategory(String name, String icon) {
        this.categoryName = name;
        this.categoryIcon = icon;
    }

    public BlogCategory(Long categoryId, String name, String icon) {
        this.id = categoryId;
        this.categoryName = name;
        this.categoryIcon = icon;
    }
}