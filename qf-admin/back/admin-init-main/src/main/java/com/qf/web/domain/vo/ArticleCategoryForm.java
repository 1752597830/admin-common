package com.qf.web.domain.vo;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author : sin
 * @date : 2023/12/18 15:17
 * @Description : 文章分类表单
 */
@Data
@AllArgsConstructor
@Tag(name = "文章分类")
@ToString
public class ArticleCategoryForm {

    private String name;

    private String icon;
}