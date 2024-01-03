package com.qf.web.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author : sin
 * @date : 2023/12/17 15:49
 * @Description : Options 菜单权限
 */
@Data
@ToString
@AllArgsConstructor
public class MenuOptions {
    /**
     * 选项值  id
     */
    private Long value;

    /**
     * 选项名称  name
     */
    private String label;

    /**
     * 父id
     */
    private Long parentId;
}