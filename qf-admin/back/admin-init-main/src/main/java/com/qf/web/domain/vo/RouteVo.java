package com.qf.web.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author : sin
 * @date : 2023/12/15 19:10
 * @Description : 路由表
 */
@Data
@ToString
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
        private String title;
        // 图标
        private String icon;
        // 是否隐藏
        private boolean hidden;

        // 用户角色列表
        private List<String> roles;

        // 是否保持常驻
        private boolean keepAlive;
    }

    private Meta meta;
    // 子路由
    private List<RouteVo> children;
}