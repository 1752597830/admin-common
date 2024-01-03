package com.qf.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.domain.entity.SysDict;
import com.qf.web.domain.dto.OptionsDto;
import com.qf.web.service.SysDictService;
import com.qf.web.mapper.SysDictMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_dict(字典数据表)】的数据库操作Service实现
* @createDate 2023-12-16 21:06:52
*/
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict>
    implements SysDictService{

    @Resource
    private SysDictMapper sysDictMapper;

    /**
    *  字典下拉列表
    */
    @Override
    public List<OptionsDto> dictOptions(String typeCode) {
        return sysDictMapper.selectDictByTypeCode(typeCode);
    }
}




