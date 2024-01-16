package com.qf.web.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author : sin
 * @date : 2024/1/16 18:04
 * @Description : 角色分页响应对象
 */
@Schema(description = "角色分页响应对象")
@Data
@AllArgsConstructor
@ToString
public class RolePageVo {

    @Schema(description = "角色ID")
    private Long id;

    @Schema(description = "角色名称")
    private String name;

    @Schema(description = "角色编码")
    private String code;

    @Schema(description = "显示顺序")
    private Integer sort;

    @Schema(description = "状态：0-正常，1-停用")
    private Integer status;

    @Schema(description = "逻辑删除标识(0-未删除；1-已删除)")
    private Integer deleted;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @Schema(description = "更新时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
}