package com.qf.web.system.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : sin
 * @date : 2024/1/15 21:45
 * @Description : 分页用户响应对象
 */
@Schema(title ="分页用户响应对象")
@Data
@AllArgsConstructor
public class UserPageVo {

    @Schema(description = "用户ID")
    private Long id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "手机号码")
    private String mobile;

    @Schema(description = "性别：0-女，1-男")
    private String gender;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "状态：0-禁用，1-正常")
    private String status;

    @Schema(description = "创建时间")
    private String createTime;
}