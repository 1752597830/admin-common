package com.qf.web.system.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : sin
 * @date : 2024/1/14 21:26
 * @Description : 用户查询类
 */
@Schema(description = "用户查询类")
@Data
@AllArgsConstructor
public class UserSearchDto {

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "状态")
    private Integer status;
}