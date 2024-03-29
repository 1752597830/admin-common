package com.qf.common.core.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : sin
 * @date : 2024/1/14 12:28
 * @Description : 分页参数封装
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDto {

    /* 当前记录起始索引 */
    private Integer pageNum;

    /* 每页显示的记录数 */
    private Integer pageSize;
}