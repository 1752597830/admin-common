package com.qf.web.system.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "用户原密码不能为空")
    private String oldPassword;

    @Schema(description = "用户新密码")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*\\d)[a-zA-Z0-9]{8,}$",
            message = "密码必须至少包含一个小写字母、一个数字，且长度至少为8")
    private String newPassword;

    @Schema(description = "用户确认密码")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*\\d)[a-zA-Z0-9]{8,}$",
            message = "密码必须至少包含一个小写字母、一个数字，且长度至少为8")
    private String confirmPassword;
}