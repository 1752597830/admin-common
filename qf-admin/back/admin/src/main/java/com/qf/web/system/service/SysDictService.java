package com.qf.web.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.web.system.domain.entity.SysDict;
import com.qf.web.system.domain.vo.DictPageVo;
import com.qf.web.system.domain.vo.OptionsVo;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_dict(字典数据表)】的数据库操作Service
* @createDate 2024-01-17 16:31:31
*/
public interface SysDictService extends IService<SysDict> {

    List<OptionsVo> dictOptions(String typeCode);

    List<DictPageVo> dictValuePage(String code);
}
