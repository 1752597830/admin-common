package com.qf.web.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author : sin
 * @date : 2024/1/17 16:38
 * @Description : 字典值分页数据
 */
@Schema(title = "字典值分页数据")
@Data
@AllArgsConstructor
@ToString
public class DictPageVo {

    @Schema(title = "id")
    private Long id;

    @Schema(title = "名称")
    private String name;

    @Schema(title = "类型编码")
    private String typeCode;

    @Schema(title = "状态")
    private Integer status;

    @Schema(title = "值")
    private String value;

    @Schema(title = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}