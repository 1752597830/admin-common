package com.qf.web.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 文章分类关联表
 * @TableName article_category
 */
@TableName(value ="article_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleCategory implements Serializable {
    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 分类ID
     */
    private Long categoryId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}