package com.qf.web.system.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : sin
 * @date : 2024/1/17 21:26
 * @Description :
 */
@Schema(title = "字典类型表单对象")
@Data
@AllArgsConstructor
public class DictTypeForm {

    @Schema(title = "字典类型名称")
    @NotBlank(message = "字典类型名称不能为空")
    private String name;

    @Schema(title = "字典类型编码")
    @NotBlank(message = "字典类型编码不能为空")
    private String code;

    @Schema(title = "状态")
    private Integer status;

    @Schema(title = "字典类型描述")
    private String remark;
}