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
    name?: string;
    version?: string;
    startTime?: Date;
    runTime?: string;
    home?: string;
    userDir?: string;
    inputArgs?: string;
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
/**
 * 磁盘信息
 */
export interface sysFiles {
    dirName?: string;
    sysTypeName?: string;
    typeName?: string;
    total?: string;
    free?: string;
    used?: string;
    usage?: number;
}
export interface severData {
    cpu?: cpu;
    mem?: mem;
    jvm?: jvm;
    sys?: sys;
    sysFiles?: sysFiles;
}