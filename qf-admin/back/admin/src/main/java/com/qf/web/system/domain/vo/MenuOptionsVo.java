package com.qf.web.system.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author : sin
 * @date : 2024/1/16 15:01
 * @Description : 菜单下拉选项
 */

@Data
@ToString
@AllArgsConstructor
@Schema(description ="菜单下拉选项响应对象")
public class MenuOptionsVo {
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
    private List<MenuOptionsVo> children;
}