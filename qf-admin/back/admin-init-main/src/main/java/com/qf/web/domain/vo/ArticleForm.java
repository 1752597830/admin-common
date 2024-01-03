package com.qf.web.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


/**
 * @author : sin
 * @date : 2023/12/18 9:37
 * @Description : 文章表单对象
 */
@Schema(description = "文章表单对象")
@Data
@ToString
@AllArgsConstructor
public class ArticleForm {

    /**
     * 文章标题 不能为空
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章标签
     */
    private String tagId;

    /**
     * 文章分类
     */
    private String categoryId;

    /**
     * 文章缩略图
     */
    private String cover;

    /**
     * 是否置顶 1 置顶 2 取消置顶
     */
    private Integer is_top;

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
    private String origin_url;

    /**
     * 描述信息 不能为空
     */
    private String description;
}