package com.qf.web.system.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : sin
 * @date : 2024/1/17 21:50
 * @Description :
 */
@Schema(title = "字典表单对象")
@Data
@AllArgsConstructor
public class DictForm {

    @Schema(title = "字典类型编码")
    @NotBlank(message = "字典类型编码不能为空")
    private String typeCode;

    @Schema(title = "字典类型名称")
    @NotBlank(message = "字典类型名称不能为空")
    private String name;

    @Schema(title = "字典值")
    @NotBlank(message = "字典值不能为空")
    private String value;

    @Schema(title = "字典值描述")
    private String remark;
}