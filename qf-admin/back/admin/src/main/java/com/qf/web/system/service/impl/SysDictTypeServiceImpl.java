package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.common.constant.CommonConstant;
import com.qf.common.enmu.ResponseCode;
import com.qf.common.exception.BaseException;
import com.qf.web.system.domain.entity.SysDictType;
import com.qf.web.system.domain.form.DictTypeForm;
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

    /**
     * @author: sin
     * @Description 新增字典类型 添加时需要判断code是否存在
     */
    @Override
    public int saveDictType(DictTypeForm dictTypeForm) {
        if(dictTypeMapper.selectCountByCode(dictTypeForm.getCode()) > 0){
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.DICT_TYPE_CODE_IS_EXIST);
        }
        return dictTypeMapper.save(dictTypeForm.getName(), dictTypeForm.getCode(),dictTypeForm.getStatus(),dictTypeForm.getRemark());
    }

    /*
    * @description 修改字典类型
    * @param dictTypeForm
    * @return int
    */
    @Override
    public int updateDictType(Long id,DictTypeForm dictTypeForm) {
        return dictTypeMapper.updateDictType(id,dictTypeForm.getName(),dictTypeForm.getRemark());
    }

    /*
    * @description 删除字典类型
    * @param typeId
    * @return int
    */
    @Override
    public int deleteDictType(Long typeId) {
        return dictTypeMapper.deleteById(typeId);
    }
}




