package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.system.domain.entity.SysDictType;
import com.qf.web.system.domain.vo.DictTypeVo;
import com.qf.web.system.service.SysDictTypeService;
import com.qf.web.system.mapper.SysDictTypeMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_dict_type(字典类型表)】的数据库操作Service实现
* @createDate 2024-01-17 16:31:31
*/
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType>
    implements SysDictTypeService{

    @Resource
    SysDictTypeMapper dictTypeMapper;


    /**
    * @description 获取字典类型列表
    * @return java.util.List<com.qf.web.system.domain.vo.DictTypeVo>
    */
    @Override
    public List<DictTypeVo> dictTypes() {
        return dictTypeMapper.selectDictTypes();
    }
}




