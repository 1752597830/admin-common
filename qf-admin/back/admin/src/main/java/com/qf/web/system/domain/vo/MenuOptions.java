package com.qf.web.system.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author : sin
 * @date : 2024/1/16 15:10
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