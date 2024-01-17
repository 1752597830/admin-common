package com.qf.web.system.controller;

import com.qf.common.core.controller.BaseController;
import com.qf.common.core.page.PageResult;
import com.qf.common.util.BaseResponse;
import com.qf.web.system.domain.vo.DictPage;
import com.qf.web.system.domain.vo.DictPageVo;
import com.qf.web.system.domain.vo.OptionsVo;
import com.qf.web.system.service.SysDictService;
import com.qf.web.system.service.SysDictTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : sin
 * @date : 2024/1/17 16:24
 * @Description : 字典接口
 */
@Tag(name = "05.字典接口")
@RestController
@RequestMapping("/dicts")
@Slf4j
public class DictController extends BaseController {

    @Resource
    SysDictService dictService;

    @Resource
    SysDictTypeService dictTypeService;

    /**
     * 字典下拉列表
     *
     * @param typeCode 字典类型
     */
    @Operation(summary = "获取字典下拉列表", description = "根据typeCode获取字典下拉列表")
    @GetMapping("/{typeCode}/options")
    public BaseResponse dictOptions(@Parameter(description = "字典类型编码") @PathVariable String typeCode) {
        List<OptionsVo> voList = dictService.dictOptions(typeCode);
        return BaseResponse.success(voList);
    }

    /**
     * @author: sin
     * @Description 根据code编码获取字典值
     */
    @Operation(summary = "获取字典值分页数据", description = "根据code编码获取字典值分页数据")
    @GetMapping("/page")
    public BaseResponse getDictValuePage(DictPage dictPage){
        startPage();
        List<DictPageVo> list = dictService.dictValuePage(dictPage.getCode());
        System.out.println(list);
        PageResult pageResult = getData(list);
        System.out.println(pageResult);
        return BaseResponse.success(pageResult);
    }

    /**
     * @author: sin
     * @Description 字典类型列表
     */
    @Operation(summary = "获取字典类型列表", description = "获取所有字典类型列表")
    @GetMapping("/types/page")
    public BaseResponse dictTypes(){
        return BaseResponse.success(dictTypeService.dictTypes());
    }
}