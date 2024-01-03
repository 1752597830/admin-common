package com.qf.web.domain.dto;

import com.qf.common.core.page.PageDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : sin
 * @date : 2023/12/17 13:19
 * @Description : 角色分页
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RolePage extends PageDomain {
    /**
     * 关键字
     */
    private String keywords;
}