package com.qf.web.system.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author : sin
 * @date : 2024/1/14 21:26
 * @Description : 用户表单
 */
@Schema(description = "用户表单")
@Data
@ToString
public class UserForm {
    @Schema(description = "用户账号")
    @NotBlank(message = "用户账号不能为空")
    private String username;

    @Schema(description = "用户昵称")
    @NotBlank(message = "用户昵称不能为空")
    private String nickname;

    @Schema(description = "用户邮箱")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "邮箱地址格式不正确")
    private String email;

    @Schema(description = "用户手机号")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String mobile;

    @Schema(description = "用户性别")

    private Integer gender;

    @Schema(description = "用户头像")
    private String avatar;

    @Schema(description="用户状态(0:正常;1:禁用)")
    private Integer status;

    @Schema(description = "角色ID集合")
    private List<Long> roleIds;
}