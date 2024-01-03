package com.qf.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.domain.entity.ArticleTag;
import com.qf.web.service.ArticleTagService;
import com.qf.web.mapper.ArticleTagMapper;
import org.springframework.stereotype.Service;

/**
* @author 清风
* @description 针对表【article_tag(文章标签关联表)】的数据库操作Service实现
* @createDate 2023-12-18 09:31:17
*/
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag>
    implements ArticleTagService{

}




