package com.qf.web.system.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : sin
 * @date : 2024/1/14 21:26
 * @Description : 用户查询类
 */
@Schema(description = "用户查询类")
@Data
@AllArgsConstructor
public class UserSearchDto {

    @Schema(description = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Schema(description = "手机号")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String phone;

    @Schema(description = "状态")
    private Integer status;
}