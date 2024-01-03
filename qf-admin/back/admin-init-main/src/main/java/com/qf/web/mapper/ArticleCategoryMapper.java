package com.qf.web.mapper;

import com.qf.web.domain.entity.ArticleCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 清风
* @description 针对表【article_category(文章分类关联表)】的数据库操作Mapper
* @createDate 2023-12-18 09:31:17
* @Entity com.qf.web.domain.entity.ArticleCategory
*/
@Mapper
public interface ArticleCategoryMapper extends BaseMapper<ArticleCategory> {

}




