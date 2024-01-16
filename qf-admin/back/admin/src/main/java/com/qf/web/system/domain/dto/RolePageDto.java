package com.qf.web.system.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author : sin
 * @date : 2024/1/16 17:57
 * @Description : 角色分页请求参数
 */
@Schema(description = "角色分页请求参数")
@Data
@AllArgsConstructor
@ToString
public class RolePageDto {

    @Schema(description = "角色名称")
    private String name;

    @Schema(description = "角色标识,code")
    private String code;

    @Schema(description = "角色状态")
    private Integer status;
}