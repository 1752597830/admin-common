/**
 * 角色查询参数
 */
// export interface RoleQuery extends PageQuery {
//     name?: string;
//     code?: string;
//     status?: number;
// }
/**
 * cpu参数
 */
export interface CPU {
    name?: string;
    value?: string;
}
/**
 * 内存
 */
export interface MEM {
    name?: string;
    mem?: string;
    JVM?: string
}