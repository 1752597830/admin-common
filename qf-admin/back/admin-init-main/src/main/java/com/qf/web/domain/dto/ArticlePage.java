package com.qf.web.domain.dto;

import com.qf.common.core.page.PageDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author : sin
 * @date : 2023/12/18 16:16
 * @Description :
 */

@Data
@AllArgsConstructor
@ToString
public class ArticlePage extends PageDomain{
    private String keywords;
}
