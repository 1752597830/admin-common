package com.qf.web.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 文章表
 *
 * @TableName blog_article
 */
@TableName(value = "blog_article")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogArticle implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文章标题 不能为空
     */
    private String articleTitle;

    /**
     * 文章作者 不能为空
     */
    private Long authorId;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章缩略图
     */
    private String articleCover;

    /**
     * 是否置顶 1 置顶 2 取消置顶
     */
    private Integer isTop;

    /**
     * 文章状态  1 公开 2 私密 3 草稿箱
     */
    private Integer status;

    /**
     * 文章类型 1 原创 2 转载 3 翻译
     */
    private Integer type;

    /**
     * 原文链接 是转载或翻译的情况下提供
     */
    private String originUrl;

    /**
     * 文章访问次数
     */
    private Integer viewTimes;

    /**
     * 描述信息 不能为空
     */
    private String articleDescription;

    /**
     * 文章点赞次数
     */
    private Integer thumbsUpTimes;

    /**
     * 文章阅读时长
     */
    private Double readingDuration;

    /**
     * 排序 1 最大 往后越小 用于置顶文章的排序
     */
    private Integer sort;

    /**
     * 文章是否被删除 0:未删除;1:已删除
     */
    @TableLogic(value = "0", delval = "1")
    private Integer deleted;

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

    public BlogArticle(String title, String content, String cover, Integer isTop, Integer status, Integer type, Long authorId, String originUrl, String description) {
        this.articleTitle = title;
        this.articleContent = content;
        this.articleCover = cover;
        this.isTop = isTop;
        this.status = status;
        this.type = type;
        this.authorId = authorId;
        this.originUrl = originUrl;
        this.articleDescription = description;
    }

    public BlogArticle(Long articleId, String title, String content, String cover, Integer isTop, Integer status, Integer type, String originUrl, String description) {
        this.id = articleId;
        this.articleTitle = title;
        this.articleContent = content;
        this.articleCover = cover;
        this.isTop = isTop;
        this.status = status;
        this.type = type;
        this.originUrl = originUrl;
        this.articleDescription = description;
    }
}