package com.qf.web.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author : sin
 * @date : 2023/12/15 17:19
 * @Description : 封装返回用户信息
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    /*用户id*/
    private Long userId;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户的手机号码
     */
    private String mobile;

    /**
     * 用户的性别
     */
    private Integer gender;

    /**
     * 用户的邮箱
     */
    private String email;

    /**
     * 用户创建的时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 用户角色列表
     */
    private List<String> roles;

    /**
     * 用户权限列表
     */
    private List<String> perms;

}