package com.qf.web.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.web.system.domain.entity.SysDict;
import com.qf.web.system.domain.vo.DictPageVo;
import com.qf.web.system.domain.vo.OptionsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_dict(字典数据表)】的数据库操作Mapper
* @createDate 2024-01-17 16:31:31
* @Entity com.qf.web.system.domain.entity.SysDict
*/
@Mapper
public interface SysDictMapper extends BaseMapper<SysDict> {

    List<OptionsVo> selectDictByTypeCode(String typeCode);

    List<DictPageVo> dictValuePage(String code);

}




