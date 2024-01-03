package com.qf.web.mapper;

import com.qf.web.domain.entity.SysDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.web.domain.dto.OptionsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_dict(字典数据表)】的数据库操作Mapper
* @createDate 2023-12-16 21:06:52
* @Entity com.qf.web.domain.entity.SysDict
*/
@Mapper
public interface SysDictMapper extends BaseMapper<SysDict> {

    List<OptionsDto> selectDictByTypeCode(String typeCode);
}




