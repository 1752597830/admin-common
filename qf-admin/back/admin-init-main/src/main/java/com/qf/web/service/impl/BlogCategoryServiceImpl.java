package com.qf.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.domain.entity.BlogCategory;
import com.qf.web.domain.vo.ArticleCategoryForm;
import com.qf.web.service.BlogCategoryService;
import com.qf.web.mapper.BlogCategoryMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 清风
* @description 针对表【blog_category(分类表)】的数据库操作Service实现
* @createDate 2023-12-18 09:31:17
*/
@Service
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory>
    implements BlogCategoryService{

    @Resource
    private BlogCategoryMapper blogCategoryMapper;
    @Override
    public int save(ArticleCategoryForm categoryForm) {

        return blogCategoryMapper.insert(new BlogCategory(categoryForm.getName(),categoryForm.getIcon()));
    }

    @Override
    public int update(Long categoryId, ArticleCategoryForm categoryForm) {
        return blogCategoryMapper.updateById(new BlogCategory(categoryId,categoryForm.getName(),categoryForm.getIcon()));
    }

    @Override
    public List<BlogCategory> getPage(String keywords) {

        return blogCategoryMapper.getPage(keywords);
    }
}




