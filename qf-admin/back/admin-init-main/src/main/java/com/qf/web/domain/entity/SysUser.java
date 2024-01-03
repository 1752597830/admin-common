package com.qf.web.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @TableName sys_user
 */
@TableName(value = "sys_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysUser implements Serializable, UserDetails {
    /**
     * 用户的ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户的用户名
     */
    private String username;

    /**
     * 用户的昵称
     */
    private String nickname;

    /**
     * 用户的性别
     */
    private Integer gender;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户的头像
     */
    private String avatar;

    /**
     * 用户的手机号码
     */
    private String mobile;

    /**
     * 用户的状态 0:禁用;1:正常
     */
    private Integer status;

    /**
     * 用户的邮箱
     */
    private String email;

    /**
     * 用户是否被删除 0:未删除;1:已删除
     */
    @TableLogic(value = "0", delval = "1")
    @TableField(select = false)
    private Integer deleted;

    /**
     * 用户创建的时间
     */
    private Date createTime;

    /**
     * 用户最后更新的时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    /**
     * 用户创建的账号
     */
    private String createBy;

    /**
     * 用户最后更新的账号
     */
    private String updateBy;

    /**
     * 用户拥有的角色
     */
    @TableField(exist = false)
    private List<String> roles;

    /**
     * 用户的权限
     */
    @TableField(exist = false)
    private List<String> perms;

    /**
     * 序列化版本UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取用户所具有的权限perms
     *
     * @return 返回用户所具有的权限列表，如果没有权限则返回null
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    /**
     * 判断账户是否非过期
     *
     * @return 如果账户过期返回false，否则返回true
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    /**
     * 判断账户是否被锁定（逻辑删除）
     *
     * @return 如果账户被锁定返回true，否则返回false
     */
    @Override
    public boolean isAccountNonLocked() {
        return this.deleted == 0 ? true : false;
    }


    /**
     * 判断密码是否过期
     *
     * @return 如果密码过期返回true，否则返回false
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    /**
     * 判断当前对象是否启用
     *
     * @return 如果当前对象启用，返回true；否则返回false
     */
    @Override
    public boolean isEnabled() {
        return this.status == 1 ? true : false;
    }

    public SysUser(Long id, String username, String nickname, Integer gender, String password, String mobile, Integer status, String email) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.gender = gender;
        this.password = password;
        this.mobile = mobile;
        this.status = status;
        this.email = email;
    }
}