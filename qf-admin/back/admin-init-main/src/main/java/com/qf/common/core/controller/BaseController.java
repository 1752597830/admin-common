package com.qf.common.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.common.core.page.PageDomain;
import com.qf.common.core.page.PageResult;
import com.qf.common.utils.BaseResponse;
import com.qf.common.utils.ResponseCode;
import com.qf.common.utils.ServletUtils;

import java.util.List;

/**
 * @author : sin
 * @date : 2023/11/26 16:12
 * @Description : 抽取公共控制器
 */
public class BaseController {

    /* 当前记录起始索引 */
    public static final String PAGE_NUM = "pageNum";

    /* 每页显示记录数 */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 封装分页数据
     */
    public static PageDomain getPageDomain() {
        PageDomain pageDomain = new PageDomain(ServletUtils.getParameterToInt(PAGE_NUM),ServletUtils.getParameterToInt(PAGE_SIZE));
        return pageDomain;
    }

    /**
     * 封装PageHelp的startPage方法
     */
    protected void startPage() {
        PageDomain pageDomain = getPageDomain();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();

        if(pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
    }

    /**
     * 响应分页数据
     */
    protected PageResult getData(List<?> list) {
        PageResult pageResult = new PageResult();
        pageResult.setCode(ResponseCode.SUCCESS.getCode());
        pageResult.setMsg("查询成功");
        pageResult.setList(list);
        pageResult.setTotal(list == null ? 0 : new PageInfo(list).getTotal());
        return pageResult;
    }

    /**
     * 响应返回结果
     * 针对增删改操作  判断rows
     */
    protected BaseResponse toAjax(int rows){
        return rows > 0 ? BaseResponse.success(rows) : BaseResponse.fail("操作失败");
    }
}