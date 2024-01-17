package com.qf.web.system.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @author : sin
 * @date : 2024/1/17 16:42
 * @Description : 字典类型响应对象
 */

@Schema(title = "字典类型响应对象")
@AllArgsConstructor
@ToString
public class DictTypeVo {
    @Schema(title = "id")
    private Long id;

    @Schema(title = "类型编码")
    private String code;

    @Schema(title = "类型名称")
    private String name;
}