package com.qf.web.system.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
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
    private String name;

    @Schema(description="角色编码")
    private String code;

    @Schema(description = "备注信息")
    private String remark;
}