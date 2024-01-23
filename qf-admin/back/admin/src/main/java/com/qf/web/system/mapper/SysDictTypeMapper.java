package com.qf.web.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.web.system.domain.entity.SysDictType;
import com.qf.web.system.domain.vo.DictTypeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_dict_type(字典类型表)】的数据库操作Mapper
* @createDate 2024-01-17 16:31:31
* @Entity com.qf.web.system.domain.entity.SysDictType
*/
@Mapper
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    List<DictTypeVo> selectDictTypes();

    int save(String name, String code, Integer status, String remark);

    int updateDictType(Long id, String name, String remark);

    int selectCountByCode(String code);
}




