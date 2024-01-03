package com.qf.web.service;

import com.qf.web.domain.entity.BlogArticle;
import com.qf.web.domain.entity.BlogCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.web.domain.vo.ArticleCategoryForm;

import java.util.List;

/**
* @author 清风
* @description 针对表【blog_category(分类表)】的数据库操作Service
* @createDate 2023-12-18 09:31:17
*/
public interface BlogCategoryService extends IService<BlogCategory> {

    int save(ArticleCategoryForm categoryForm);

    int update(Long categoryId, ArticleCategoryForm categoryForm);

    List<BlogCategory> getPage(String keywords);
}
