package com.qf.web.controller;

import com.qf.common.core.controller.BaseController;
import com.qf.common.utils.BaseResponse;
import com.qf.web.domain.entity.BlogArticle;
import com.qf.web.domain.entity.BlogCategory;
import com.qf.web.domain.vo.ArticleCategoryForm;
import com.qf.web.domain.vo.ArticleForm;
import com.qf.web.domain.vo.UserForm;
import com.qf.web.service.BlogArticleService;
import com.qf.web.service.BlogCategoryService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : sin
 * @date : 2023/12/18 9:33
 * @Description : 文章控制层
 */
@RestController
@RequestMapping("/article")
@Tag(name = "文章管理")
@Slf4j
public class ArticleController extends BaseController {

    @Resource
    private BlogArticleService blogArticleService;


    /**
     * 新增文章
     */
    @PostMapping("")
    @Schema(title = "新增文章")
    public BaseResponse save(@RequestBody ArticleForm form) {
        System.out.println(form);
        return toAjax(blogArticleService.save(form));
    }
    /**
     * @author: sin
     * @Description 文章分页列表
     */
    @GetMapping("/page")
    @Schema(title = "文章分页列表")
    public BaseResponse getPage(String keywords) {
        startPage();
        List<BlogArticle> articles = blogArticleService.getPage(keywords);
        return BaseResponse.success(getData(articles));
    }

    /**
     * @author: sin
     * @Description 修改文章
     */
    @PutMapping("/{articleId}")
    public BaseResponse update(@PathVariable Long articleId,@RequestBody ArticleForm articleForm) {
        log.info("修改文章,{articleForm}" + articleForm);
        log.info("修改文章,{articleId}" + articleId);
        return toAjax(blogArticleService.update(articleId,articleForm));
    }

    /**
     * @author: sin
     * @Description 删除文章
     */
    @DeleteMapping("/{articleId}")
    public BaseResponse delete(@PathVariable Long articleId) {
        log.info("删除文章,{articleId}" + articleId);
        return toAjax(blogArticleService.delete(articleId));
    }
}