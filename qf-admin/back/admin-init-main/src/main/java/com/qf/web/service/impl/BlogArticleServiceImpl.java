package com.qf.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.common.utils.SecurityUtils;
import com.qf.web.domain.entity.BlogArticle;
import com.qf.web.domain.entity.SysUser;
import com.qf.web.domain.vo.ArticleForm;
import com.qf.web.service.BlogArticleService;
import com.qf.web.mapper.BlogArticleMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 清风
 * @description 针对表【blog_article(文章表)】的数据库操作Service实现
 * @createDate 2023-12-18 09:31:17
 */
@Service
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle>
        implements BlogArticleService {

    @Resource
    private BlogArticleMapper blogArticleMapper;


    /**
     * 新增文章
     *
     * @param form 请求表单
     * @author sin
     */
    @Override
    public int save(ArticleForm form) {
        SysUser user = SecurityUtils.getUserInfo();
        BlogArticle blogArticle = new BlogArticle(form.getTitle(), form.getContent(), form.getCover(), form.getIs_top(), form.getStatus(), form.getType(), user.getId(), form.getOrigin_url(), form.getDescription());
        return blogArticleMapper.insert(blogArticle);
    }

    @Override
    public List<BlogArticle> getPage(String keywords) {

        return blogArticleMapper.getPage(keywords);
    }

    @Override
    public int delete(Long articleId) {
        return blogArticleMapper.deleteById(articleId);
    }

    @Override
    public int update(Long articleId, ArticleForm form) {
        BlogArticle blogArticle = new BlogArticle(articleId, form.getTitle(), form.getContent(), form.getCover(), form.getIs_top(), form.getStatus(), form.getType(), form.getOrigin_url(), form.getDescription());
        return blogArticleMapper.updateById(blogArticle);
    }
}




