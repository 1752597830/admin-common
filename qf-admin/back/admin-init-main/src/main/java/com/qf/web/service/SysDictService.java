package com.qf.web.service;

import com.qf.web.domain.entity.SysDict;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.web.domain.dto.OptionsDto;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_dict(字典数据表)】的数据库操作Service
* @createDate 2023-12-16 21:06:52
*/
public interface SysDictService extends IService<SysDict> {

    List<OptionsDto> dictOptions(String typeCode);
}
