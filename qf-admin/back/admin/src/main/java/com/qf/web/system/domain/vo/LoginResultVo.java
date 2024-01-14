package com.qf.web.system.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : sin
 * @date : 2024/1/14 17:28
 * @Description : 登录成功封装返回对象
 */
@Schema(description ="登录响应对象")
@Data
@AllArgsConstructor
public class LoginResultVo {

    @Schema(description = "访问token")
    private String accessToken;

    @Schema(description = "token 类型",example = "Bearer")
    private String tokenType;

    @Schema(description = "刷新token")
    private String refreshToken;

    @Schema(description = "过期时间(单位：毫秒)")
    private Long expires;
}
