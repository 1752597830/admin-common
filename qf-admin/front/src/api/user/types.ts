/**
 * 登录用户信息
 */
export interface UserInfo {
    userId?: number;
    username?: string;
    nickname?: string;
    avatar?: string;
    mobile?: string;
    gender?: number;
    email?: string;
    createTime?: Date;
    roles: string[];
    perms: string[];
}
/**
 * 用户修改信息表单
 */
export interface UserInfoForm {
    userId?: number;
    nickname?: string;
    mobile?: string;
    gender?: number;
    email?: string;
}
/**
 * 用户修改密码表单
 */
export interface UserPwdForm {
    oldpwd?: string;
    newpwd?: string;
    confirmpwd?: string;
}
/**
 * 用户查询对象类型
 */
export interface UserQuery extends PageQuery {
    username?: string;
    phone?: string;
    status?: number;
}
/**
 * 用户分页对象
 */
export interface UserPageVO {
    /**
     * 用户头像地址
     */
    avatar?: string;
    /**
     * 创建时间
     */
    createTime?: Date;
    /**
     * 用户邮箱
     */
    email?: string;
    /**
     * 性别
     */
    gender?: string;
    /**
     * 用户ID
     */
    id?: number;
    /**
     * 手机号
     */
    mobile?: string;
    /**
     * 用户昵称
     */
    nickname?: string;
    /**
     * 用户状态(1:启用;0:禁用)
     */
    status?: number;
    /**
     * 用户名
     */
    username?: string;
}

/**
 * 用户表单类型
 */
export interface UserForm {
    /**
     * 用户头像
     */
    avatar?: string;
    /**
     * 邮箱
     */
    email?: string;
    /**
     * 性别
     */
    gender?: number;
    /**
     * 用户ID
     */
    id?: number;
    
    mobile?: string;
    /**
     * 昵称
     */
    nickname?: string;
    /**
     * 角色ID集合
     */
    roleIds?: number[];
    /**
     * 用户状态(1:正常;0:禁用)
     */
    status?: number;
    /**
     * 用户名
     */
    username?: string;
}
