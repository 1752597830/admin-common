package com.qf.web.domain.dto;

import com.qf.common.core.page.PageDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author : sin
 * @date : 2023/12/15 22:44
 * @Description : 用户分页请求
 */
@Data
@AllArgsConstructor
@ToString
public class UserPage extends PageDomain {

    private String keywords;

    private Integer status;

    private String startTime;

    private String endTime;
}