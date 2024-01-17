package com.qf.web.system.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(title = "菜单权限下拉列表")
public class MenuOptions {

    @Schema(description = "选项值")
    private Long value;

    @Schema(description = "选项名称")
    private String label;

    @Schema(description = "父id")
    private Long parentId;
}