package com.qf.web.controller;

import com.qf.common.core.controller.BaseController;
import com.qf.common.utils.BaseResponse;
import com.qf.web.domain.entity.BlogCategory;
import com.qf.web.domain.vo.ArticleCategoryForm;
import com.qf.web.service.BlogCategoryService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : sin
 * @date : 2023/12/18 15:45
 * @Description :
 */
@RestController
@RequestMapping("/category")
@Tag(name = "文章分类管理")
@Slf4j
public class ArticleCategoryController extends BaseController {

    @Resource
    private BlogCategoryService blogCategoryService;


    /**
     * @author: sin
     * @Description 分类添加
     */
    @PostMapping("")
    public BaseResponse addCategory(@RequestBody ArticleCategoryForm categoryForm) {
        // todo 需要判断是否已经存在相同name的分类
        log.info("分类添加,{category}" + categoryForm);
        int result = 0;
        try {
            result = blogCategoryService.save(categoryForm);
        } catch (Exception e) {
            return BaseResponse.fail("分类名冲突,添加失败!");
        }
        return toAjax(result);
    }

    /**
     * @author: sin
     * @Description 修改分类
     */
    @PutMapping("/{categoryId}")
    public BaseResponse updateCategory(@PathVariable Long categoryId, @RequestBody ArticleCategoryForm categoryForm) {
        // todo 需要判断是否已经存在相同name的分类
        log.info("修改分类,{category}" + categoryForm);
        log.info("修改分类,{categoryId}" + categoryId);
        int result = 0;
        try {
            result = blogCategoryService.update(categoryId,categoryForm);
        } catch (Exception e) {
            return BaseResponse.fail("分类名冲突,修改失败!");
        }
        return toAjax(result);
    }

    /**
     * @author: sin
     * @Description 分类列表
     */
    @GetMapping("/page")
    @Schema(title = "文章分类列表")
    public BaseResponse getCategoryList(String keywords) {
        startPage();
        List<BlogCategory> categories = blogCategoryService.getPage(keywords);
        return BaseResponse.success(getData(categories));
    }
}