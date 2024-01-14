package com.qf.web.system.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * @author : sin
 * @date : 2024/1/14 21:26
 * @Description : 新增用户表单
 */
@Schema(description = "新增用户表单")
@Data
@ToString
public class UserForm {
    @Schema(description = "用户账号")
    private String username;
    @Schema(description = "用户昵称")
    private String nickname;
    @Schema(description = "用户邮箱")
    private String email;
    @Schema(description = "用户手机号")
    private String mobile;
    @Schema(description = "用户性别")
    private Integer gender;
    @Schema(description = "用户头像")
    private String avatar;
}