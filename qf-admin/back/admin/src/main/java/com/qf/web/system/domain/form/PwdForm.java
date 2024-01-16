package com.qf.web.system.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author : sin
 * @date : 2024/1/16 10:23
 * @Description : 用户修改密码表单
 */
@Schema(description = "用户修改密码表单")
@Data
@ToString
@AllArgsConstructor
public class PwdForm {

    @Schema(description = "用户原密码")
    private String oldPassword;

    @Schema(description = "用户新密码")
    private String newPassword;

    @Schema(description = "用户确认密码")
    private String confirmPassword;
}