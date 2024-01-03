package com.qf.web.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author : sin
 * @date : 2023/12/16 20:45
 * @Description : 下拉选项  性别、角色
 */
@Data
@ToString
@AllArgsConstructor
@Schema(description ="性别、角色下拉选项响应对象")
public class OptionsDto {

    /**
     * 选项值
     */
    private Long value;

    /**
     * 选项名称
     */
    private String label;

}