package com.qf.web.system.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author : sin
 * @date : 2024/1/14 20:09
 * @Description : 用户信息封装
 */
@Schema(description ="获取用户信息响应对象")
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class UserInfoVo {

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "用户账号")
    private String username;

    @Schema(description = "用户昵称")
    private String nickname;

    @Schema(description = "用户性别")
    private Integer gender;

    @Schema(description = "用户头像")
    private String avatar;

    @Schema(description = "用户邮箱")
    private String email;

    @Schema(description = "用户手机号")
    private String mobile;

    @Schema(description = "用户个人简介")
    private String content;

    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 用户角色列表
     */
    @Schema(description = "用户角色列表")
    private List<String> roles;

    /**
     * 用户权限列表
     */
    @Schema(description = "用户权限列表")
    private List<String> perms;

}