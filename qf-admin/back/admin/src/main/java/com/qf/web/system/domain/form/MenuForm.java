package com.qf.web.system.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : sin
 * @date : 2024/1/26 22:19
 * @Description : 菜单表单
 */
@Schema(description = "菜单表单")
@Data
@AllArgsConstructor
public class MenuForm {

    @Schema(description = "父菜单id")
    private Long parentId;

    @Schema(description = "菜单名称")
    private String name;

    @Schema(description = "菜单类型")
    private Integer type;

    @Schema(description = "菜单图标")
    private String icon;

    @Schema(description = "菜单路径")
    private String path;

    @Schema(description = "菜单权限")
    private String perms;

    @Schema(description = "菜单排序")
    private Integer sort;

    @Schema(description = "菜单状态")
    private Integer status;

    @Schema(description = "是否可见")
    private Integer visible;

    @Schema(description = "组件路径")
    private String component;

    @Schema(description = "跳转路径")
    private String redirect;

}