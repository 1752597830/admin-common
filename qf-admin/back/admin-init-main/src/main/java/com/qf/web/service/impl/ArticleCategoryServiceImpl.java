package com.qf.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.domain.entity.ArticleCategory;
import com.qf.web.service.ArticleCategoryService;
import com.qf.web.mapper.ArticleCategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author 清风
* @description 针对表【article_category(文章分类关联表)】的数据库操作Service实现
* @createDate 2023-12-18 09:31:17
*/
@Service
public class ArticleCategoryServiceImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategory>
    implements ArticleCategoryService{

}




