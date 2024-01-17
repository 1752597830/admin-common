package com.qf.web.system.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author : sin
 * @date : 2024/1/16 14:28
 * @Description : 封装路由信息
 */
@Schema(title ="路由响应对象")
@Data
@AllArgsConstructor
public class RouteVo {

    @Schema(description = "路由ID")
    private Long id;

    @Schema(description = "路由路径")
    private String path;

    @Schema(description = "路由组件")
    private String component;

    @Schema(description = "路由重定向")
    private String redirect;

    @Schema(description = "路由名称")
    private String name;

    @Data
    @ToString
    @AllArgsConstructor
    @Schema(description = "路由元数据")
    public static class Meta {

        @Schema(description = "路由名称")
        private String title;

        @Schema(description = "路由图标")
        private String icon;

        @Schema(description = "是否隐藏")
        private boolean hidden;

        @Schema(description = "用户角色列表")
        private List<String> roles;

        @Schema(description = "是否保持常驻")
        private boolean keepAlive;
    }

    @Schema(description = "路由元数据")
    private Meta meta;

    @Schema(description = "子路由")
    private List<RouteVo> children;
}