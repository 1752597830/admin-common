package com.qf.web.service;

import com.qf.web.domain.entity.BlogArticle;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.web.domain.vo.ArticleForm;

import java.util.List;

/**
* @author 清风
* @description 针对表【blog_article(文章表)】的数据库操作Service
* @createDate 2023-12-18 09:31:17
*/
public interface BlogArticleService extends IService<BlogArticle> {

    int save(ArticleForm form);

    List<BlogArticle> getPage(String keywords);

    int delete(Long articleId);

    int update(Long articleId, ArticleForm articleForm);
}
