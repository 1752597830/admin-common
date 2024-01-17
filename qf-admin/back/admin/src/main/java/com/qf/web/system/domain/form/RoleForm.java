package com.qf.web.system.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author : sin
 * @date : 2024/1/16 18:16
 * @Description :
 */

@Schema(description = "角色表单对象")
@Data
public class RoleForm {

    @Schema(description="角色名称")
    @NotBlank(message = "角色名称不能为空")
    private String name;

    @Schema(description="角色编码")
    @NotBlank(message = "角色编码不能为空")
    private String code;

    @Schema(description = "备注信息")
    private String remark;
}