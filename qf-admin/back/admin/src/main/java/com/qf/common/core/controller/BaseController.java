package com.qf.common.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.common.core.page.PageDto;
import com.qf.common.core.page.PageResult;
import com.qf.common.util.BaseResponse;
import com.qf.common.util.ResponseCode;
import com.qf.common.util.ServletUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : sin
 * @date : 2024/1/14 12:27
 * @Description : 分页处理控制层
 */
@RestController
public class BaseController {
    /* 当前记录起始索引 */
    public static final String PAGE_NUM = "pageNum";

    /* 每页显示记录数 */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 封装分页数据
     */
    public static PageDto getPageDto() {
        PageDto PageDto = new PageDto(ServletUtils.getParameterToInt(PAGE_NUM),ServletUtils.getParameterToInt(PAGE_SIZE));
        return PageDto;
    }

    /**
     * 封装PageHelp的startPage方法
     */
    protected void startPage() {
        PageDto PageDto = getPageDto();
        Integer pageNum = PageDto.getPageNum();
        Integer pageSize = PageDto.getPageSize();

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
    protected BaseResponse isOk(int rows){
        return rows > 0 ? BaseResponse.success(rows) : BaseResponse.fail("操作失败");
    }
}