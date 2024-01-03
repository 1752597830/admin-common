package com.qf.web.mapper;

import com.qf.web.domain.entity.BlogTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 清风
* @description 针对表【blog_tag(标签表)】的数据库操作Mapper
* @createDate 2023-12-18 09:31:17
* @Entity com.qf.web.domain.entity.BlogTag
*/
@Mapper
public interface BlogTagMapper extends BaseMapper<BlogTag> {

}




