package com.qf.web.controller;

import com.qf.common.utils.BaseResponse;
import com.qf.web.domain.dto.OptionsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import com.qf.web.service.SysDictService;

import java.util.List;


/**
 * @author : sin
 * @date : 2023/12/16 21:08
 * @Description : 字典管理
 */
@RestController
@RequestMapping("/dict")
public class SysDictController {

    @Resource
    private SysDictService sysDictService;

    /**
     * 字典下拉列表
     *
     * @param typeCode 字典类型
     */
    @Operation(summary = "字典下拉列表")
    @GetMapping("/{typeCode}/options")
    public BaseResponse dictOptions(@Parameter(description = "字典类型编码") @PathVariable String typeCode) {
        List<OptionsDto> voList = sysDictService.dictOptions(typeCode);
        return BaseResponse.success(voList);
    }
}