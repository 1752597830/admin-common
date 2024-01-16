package com.qf.web.system.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author : sin
 * @date : 2024/1/16 15:02
 * @Description :
 */
@Data
@AllArgsConstructor
@Schema(title = "菜单树响应对象")
public class MenuTreeVo {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "父级id")
    private Long parentId;

    @Schema(description = "菜单名称")
    private String name;

    @Schema(description = "菜单类型")
    private String type;

    @Schema(description = "菜单路径")
    private String path;

    @Schema(description = "菜单组件")
    private String component;

    @Schema(description = "菜单图标")
    private String icon;

    @Schema(description = "菜单排序")
    private Integer sort;

    @Schema(description = "菜单状态：0-隐藏，1-显示")
    private Integer visible;

    @Schema(description = "菜单权限")
    // sys:user:add
    private String perm;

    @Schema(description = "重定向")
    private String redirect;

    @Schema(description = "子菜单")
    private List<MenuTreeVo> children;
}