package com.qf.web.system.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.util.Collection;
import java.util.List;

import com.qf.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户信息表
 * @TableName sys_user
 */
@TableName(value ="sys_user")
@Data
@AllArgsConstructor
@ToString
public class SysUser extends BaseEntity  implements UserDetails {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 性别((1:男;2:女))
     */
    @TableField(value = "gender")
    private Integer gender;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 用户头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 联系方式
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 用户状态((1:正常;0:禁用))
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 用户邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 逻辑删除标识(0:未删除;1:已删除)
     */
    @TableLogic(value = "0", delval = "1")
    @TableField(value = "is_deleted",select = false)
    private Integer isDeleted;

    /**
     * 个人简介
     */
    @TableField(value = "content")
    private String content;

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
        return this.isDeleted == 0 ? true : false;
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

    public SysUser(Long id, String username, String nickname, Integer gender, String password,String avatar, String mobile, Integer status,String email,Integer isDeleted, String content) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.gender = gender;
        this.password = password;
        this.avatar = avatar;
        this.mobile = mobile;
        this.status = status;
        this.email = email;
        this.isDeleted = isDeleted;
        this.content = content;
    }

}