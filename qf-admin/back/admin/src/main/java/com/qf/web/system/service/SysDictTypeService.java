package com.qf.web.system.service;

import com.qf.web.system.domain.entity.SysDictType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.web.system.domain.vo.DictTypeVo;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_dict_type(字典类型表)】的数据库操作Service
* @createDate 2024-01-17 16:31:31
*/
public interface SysDictTypeService extends IService<SysDictType> {
    List<DictTypeVo> dictTypes();
}
