package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.web.system.domain.entity.SysDict;
import com.qf.web.system.domain.vo.DictPageVo;
import com.qf.web.system.domain.vo.OptionsVo;
import com.qf.web.system.mapper.SysDictMapper;
import com.qf.web.system.service.SysDictService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_dict(字典数据表)】的数据库操作Service实现
* @createDate 2024-01-17 16:31:31
*/
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict>
    implements SysDictService{

    @Resource
    SysDictMapper dictMapper;

    /**
     * @author: sin
     * @Description 根据typeCode获取下拉字典列表
     */
    @Override
    public List<OptionsVo> dictOptions(String typeCode) {
        return dictMapper.selectDictByTypeCode(typeCode);
    }

    /**
     * @param code
     * @Description 根据code编码获取字典值分页数据
     */
    @Override
    public List<DictPageVo> dictValuePage(String code) {
        List<DictPageVo> list = dictMapper.dictValuePage(code);
        return list;
    }
}



