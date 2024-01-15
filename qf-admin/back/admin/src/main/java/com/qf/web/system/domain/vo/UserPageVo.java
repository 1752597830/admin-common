package com.qf.web.system.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : sin
 * @date : 2024/1/15 21:45
 * @Description : 分页用户响应对象
 */
@Schema(description ="分页用户响应对象")
@Data
@AllArgsConstructor
public class UserPageVo {

    /**
     * 每个用户的ID
     */
    @Schema(description = "用户ID")
    private Long id;

    /**
     * 每个用户的用户名
     */
    @Schema(description = "用户名")
    private String username;

    /**
     * 每个用户的昵称
     */
    @Schema(description = "昵称")
    private String nickname;

    /**
     * 每个用户的手机号码
     */
    @Schema(description = "手机号码")
    private String mobile;

    /**
     * 每个用户的性别
     */
    @Schema(description = "性别：0-女，1-男")
    private String gender;

    /**
     * 每个用户的头像
     */
    @Schema(description = "头像")
    private String avatar;

    /**
     * 每个用户的邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * 每个用户的状态
     */
    @Schema(description = "状态：0-禁用，1-正常")
    private String status;

    /**
     * 每个用户的创建时间
     */
    @Schema(description = "创建时间")
    private String createTime;
}