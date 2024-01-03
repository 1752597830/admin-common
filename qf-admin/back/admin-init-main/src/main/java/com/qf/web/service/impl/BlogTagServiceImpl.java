package com.qf.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.domain.entity.BlogTag;
import com.qf.web.service.BlogTagService;
import com.qf.web.mapper.BlogTagMapper;
import org.springframework.stereotype.Service;

/**
* @author 清风
* @description 针对表【blog_tag(标签表)】的数据库操作Service实现
* @createDate 2023-12-18 09:31:17
*/
@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag>
    implements BlogTagService{

}




