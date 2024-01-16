package com.qf.web.system.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author : sin
 * @date : 2024/1/16 18:11
 * @Description : 封装下拉选项  性别、角色
 */
@Data
@ToString
@AllArgsConstructor
@Schema(description ="性别、角色下拉选项响应对象")
public class OptionsVo {

    @Schema(description = "选项值")
    private Long value;

    @Schema(description = "选项名称")
    private String label;
}