package com.qf.common.core.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author : sin
 * @date : 2024/1/14 12:28
 * @Description : 分页查询统一响应封装
 */
@Data
public class PageResult  implements Serializable {

    private static final long serialVersionUID = 3569196449974963450L;

    /** 总记录数 */
    private long total;

    /** 列表数据 */
    private List<?> list;

    /** 消息状态码 */
    private Integer code;

    /** 消息内容 */
    private String msg;

    public PageResult() {
    }

    /***
     * 分页
     * @param total 总记录数
     * @param list  列表数据
     * @return: null
     */
    public PageResult(long total, List<?> list) {
        this.total = total;
        this.list = list;
    }
}
