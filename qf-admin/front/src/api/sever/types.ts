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
export interface cpu {
    cpuNum?: number;
    used?: number;
    sys?: number;
    free?: number;
}
/**
 * 内存
 */
export interface mem {
    total?: number;
    used?: number;
    free?: number;
    usage?: number;
}
/**
 * jvm参数
 */
export interface jvm {
    total?: number;
    used?: number;
    free?: number;
    usage?: number;
}
/**
 * 服务器信息
 */
export interface sys {
    computerName?: string;
    osName?: string;
    computerIp?: string;
    osArch?: string;
}
export interface severData {
    cpu?: cpu;
    mem?: mem;
    jvm?: jvm;
    sys?: sys;
}