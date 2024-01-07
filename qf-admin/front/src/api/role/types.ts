/**
 * 角色查询参数
 */
export interface RoleQuery extends PageQuery {
    name?: string;
    code?: string;
    status?: number;
}

/**
 * 角色分页对象
 */
export interface RolePageVO {
    /**
   * 角色ID
   */
    id?: number;
    /**
     * 角色名称
     */
    name?: string;
    /**
     * 角色编码
     */
    code?: string;
    /**
     * 排序
     */
    sort?: number;
    /**
     * 角色状态
     */
    status?: number;
    /**
     * 删除状态
     */
    deleted?: number;
    /**
     * 备注信息
     */
    remark?: string;
    /**
     * 创建时间
     */
    createTime?: Date;
    /**
     * 修改时间
     */
    updateTime?: Date;
}

/**
 * 角色分页
 */
export type RolePageResult = PageResult<RolePageVO[]>;

/**
 * 角色表单对象
 */
export interface RoleForm {
    /**
     * 角色ID
     */
    id?: number;

    /**
     * 角色编码
     */
    code: string;

    /**
     * 角色名称
     */
    name: string;
    /**
     * 排序
     */
    sort?: number;
    /**
     * 角色状态(1-正常；0-停用)
     */
    status?: number;
    /**
     * 备注信息
     */
    remark?: string;
}
