package com.qf.web.system.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author : sin
 * @date : 2024/1/16 23:54
 * @Description : 封装角色响应对象
 */
@Schema(description = "封装角色响应对象")
@Data
public class RoleVo {

    @Schema(description="角色ID")
    private Long id;

    @Schema(description="角色名称")
    private String name;

    @Schema(description="角色编码")
    private String code;

    @Schema(description="排序")
    private Integer sort;

    @Schema(description="角色状态(1-正常；0-停用)")
    private Integer status;

    @Schema(description = "备注信息")
    private String remark;
}