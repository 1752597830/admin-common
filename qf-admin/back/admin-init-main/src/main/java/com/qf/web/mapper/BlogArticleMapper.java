package com.qf.web.mapper;

import com.qf.web.domain.entity.BlogArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 清风
* @description 针对表【blog_article(文章表)】的数据库操作Mapper
* @createDate 2023-12-18 09:31:17
* @Entity com.qf.web.domain.entity.BlogArticle
*/
@Mapper
public interface BlogArticleMapper extends BaseMapper<BlogArticle> {

    List<BlogArticle> getPage(String keywords);
}




