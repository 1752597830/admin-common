package com.qf.web.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author : sin
 * @date : 2023/12/17 15:45
 * @Description : 菜单下拉选项
 */
@Data
@ToString
@AllArgsConstructor
@Schema(description ="菜单下拉选项响应对象")
public class MenuOptionsDto {
    /**
     * 选项值
     */
    private Long value;

    /**
     * 选项名称
     */
    private String label;

    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<MenuOptionsDto> children;
}