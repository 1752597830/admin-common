package com.qf.web.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 文章标签关联表
 * @TableName article_tag
 */
@TableName(value ="article_tag")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleTag implements Serializable {
    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 标签ID
     */
    private Long tagId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}