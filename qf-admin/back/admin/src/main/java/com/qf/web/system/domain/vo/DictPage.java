package com.qf.web.system.domain.vo;

import com.qf.common.core.page.PageDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : sin
 * @date : 2024/1/17 16:40
 * @Description :
 */
@Schema(title = "字典分页数据")
@Data
@AllArgsConstructor
public class DictPage extends PageDto {

    @Schema(title = "类型编码")
    private String code;
}