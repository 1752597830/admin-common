package com.qf.web.system.controller;

import com.qf.common.core.controller.BaseController;
import com.qf.common.core.page.PageResult;
import com.qf.common.util.BaseResponse;
import com.qf.web.system.domain.form.DictForm;
import com.qf.web.system.domain.form.DictTypeForm;
import com.qf.web.system.domain.vo.DictPageVo;
import com.qf.web.system.domain.vo.DictTypeVo;
import com.qf.web.system.domain.vo.OptionsVo;
import com.qf.web.system.service.SysDictService;
import com.qf.web.system.service.SysDictTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : sin
 * @date : 2024/1/17 16:24
 * @Description : 字典接口
 */
@Tag(name = "07.字典接口")
@RestController
@RequestMapping("/dict")
@Slf4j
public class DictController extends BaseController {

    @Resource
    SysDictService dictService;

    @Resource
    SysDictTypeService dictTypeService;

    @Operation(summary = "获取字典下拉列表", description = "根据typeCode获取字典下拉列表")
    @GetMapping("/{typeCode}/options")
    public BaseResponse dictOptions(@Parameter(description = "字典类型编码") @PathVariable @NotBlank(message = "字典类型编码不能为空") String typeCode) {
        List<OptionsVo> voList = dictService.dictOptions(typeCode);
        return BaseResponse.success(voList);
    }

    @Operation(summary = "获取字典值分页数据", description = "根据code编码获取字典值分页数据")
    @GetMapping("/page")
    public BaseResponse getDictValuePage(@NotBlank(message = "字典值编码不能为空") String code) {
        startPage();
        List<DictPageVo> list = dictService.dictValuePage(code);
        System.out.println(list);
        PageResult pageResult = getData(list);
        System.out.println(pageResult);
        return BaseResponse.success(pageResult);
    }

    @Operation(summary = "获取字典类型列表", description = "获取所有字典类型列表")
    @GetMapping("/types/page")
    public BaseResponse dictTypes() {
        List<DictTypeVo> dictTypeVos = dictTypeService.dictTypes();
        return BaseResponse.success(dictTypeVos);
    }

    @Operation(summary = "新增字典类型")
    @PostMapping("/types")
    public BaseResponse saveDictType(@RequestBody @Valid DictTypeForm dictTypeForm) {
        return isOk(dictTypeService.saveDictType(dictTypeForm));
    }

    @Operation(summary = "修改字典类型")
    @PutMapping("/types/{id}")
    public BaseResponse updateDictType(@PathVariable @NotBlank(message = "字典类型id不能为空") Long id, @RequestBody @Valid DictTypeForm dictTypeForm) {
        return isOk(dictTypeService.updateDictType(id, dictTypeForm));
    }

    @Operation(summary = "删除字典类型",description = "根据typeId删除对应字典类型")
    @DeleteMapping("/types/{id}")
    public BaseResponse deleteDictType(@PathVariable @NotBlank(message = "字典类型id不能为空") Long id) {
        return isOk(dictTypeService.deleteDictType(id));
    }

    @Operation(summary = "删除指定类型的值",description = "根据typeCode删除对应字典值")
    @DeleteMapping("/values/type/{typeCode}")
    public BaseResponse deleteDictValues(@PathVariable @NotBlank(message = "字典类型编码不能为空") String typeCode) {
        return isOk(dictService.deleteDictValues(typeCode));
    }

    @Operation(summary = "新增字典值",description = "根据DictForm表单新增字典值")
    @PostMapping("/value")
    public BaseResponse saveDictValue(@RequestBody @Valid DictForm dictForm) {
        return isOk(dictService.saveDictValue(dictForm));
    }

    @Operation(summary = "修改字典值",description = "根据id修改字典值为DictForm")
    @PutMapping("/{id}")
    public BaseResponse updateDictValue(@PathVariable @NotBlank(message = "字典值id不能为空") Long id,@RequestBody @Valid DictForm dictForm) {
        return isOk(dictService.updateDictValue(id,dictForm));
    }

    @Operation(summary = "删除字典值",description = "根据id删除对应字典值")
    @DeleteMapping("/{id}")
    public BaseResponse deleteDictValue(@PathVariable @NotBlank(message = "字典值id不能为空") Long id) {
        return isOk(dictService.deleteDictById(id));
    }

    @Operation(summary = "根据id获取字典类型表单")
    @GetMapping("/types/{id}/form")
    public BaseResponse getDictTypeForm(@PathVariable @NotBlank(message = "字典值id不能为空") Long id) {
        return BaseResponse.success(dictService.getDictTypeForm(id));
    }
    @Operation(summary = "根据id获取字典值表单")
    @GetMapping("/{id}/form")
    public BaseResponse getDictValueForm(@PathVariable @NotBlank(message = "字典值id不能为空") Long id) {
        return BaseResponse.success(dictService.getDictValueForm(id));
    }
}