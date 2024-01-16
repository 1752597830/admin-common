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
@Schema(description ="路由响应对象")
@Data
@AllArgsConstructor
public class RouteVo {
    /**
     * id
     */
    private Long id;
    /**
     * 封装路径信息的类
     */
    private String path; // 路径

    /**
     * 组件信息
     */
    private String component; // 组件

    /**
     * 重定向信息
     */
    private String redirect; // 重定向

    /**
     * 名称信息
     */
    private String name; // 名称

    @Data
    @ToString
    @AllArgsConstructor
    public static class Meta {

        // 标题
        @Schema(description = "路由名称")
        private String title;

        // 图标
        @Schema(description = "路由图标")
        private String icon;

        // 是否隐藏
        @Schema(description = "是否隐藏")
        private boolean hidden;

        // 用户角色列表
        @Schema(description = "用户角色列表")
        private List<String> roles;

        // 是否保持常驻
        @Schema(description = "是否保持常驻")
        private boolean keepAlive;
    }

    @Schema(description = "路由元数据")
    private Meta meta;

    // 子路由
    @Schema(description = "子路由")
    private List<RouteVo> children;
}