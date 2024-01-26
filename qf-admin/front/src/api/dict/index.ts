import request from "@/utils/request";
import { AxiosPromise } from "axios";
import {
    DictTypeForm,
    DictQuery,
    DictForm,
    DictPageResult,
    DictTypeResult,
} from "./types";

/**
 * 字典类型列表
 *
 */
export function getDictTypeList(): AxiosPromise<DictTypeResult> {
    return request({
        url: "/dict/types/page",
        method: "get",
    });
}

/**
 * 根据code获取字典值
 */
export function getDictValueQuery(
    queryParams: DictQuery
): AxiosPromise<DictPageResult> {
    return request({
        url: "/dict/page",
        method: "get",
        params: queryParams
    })
}

/**
 * 字典类型表单数据
 *
 * @param id
 */
export function getDictTypeForm(id: number): AxiosPromise<DictTypeForm> {
    return request({
        url: "/dict/types/" + id + "/form",
        method: "get",
    });
}

/**
 * 新增字典类型
 *
 * @param data
 */
export function addDictType(data: DictTypeForm) {
    return request({
        url: "/dict/types",
        method: "post",
        data: data,
    });
}

/**
 * 修改字典类型
 *
 * @param id
 * @param data
 */
export function updateDictType(id: number, data: DictTypeForm) {
    return request({
        url: "/dict/types/" + id,
        method: "put",
        data: data,
    });
}

/**
 * 删除字典类型
 */
export function deleteDictTypes(id: string) {
    return request({
        url: "/dict/types/" + id,
        method: "delete",
    });
}

/**
 * 获取字典类型的数据项
 *
 * @param typeCode 字典类型编码
 */
export function getDictOptions(typeCode: string): AxiosPromise<OptionType[]> {
    return request({
        url: "/dict/" + typeCode + "/options",
        method: "get",
    });
}

/**
 * 字典分页列表
 */
export function getDictPage(
    queryParams: DictQuery
): AxiosPromise<DictPageResult> {
    return request({
        url: "/dict/page",
        method: "get",
        params: queryParams,
    });
}

/**
 * 获取字典表单数据
 *
 * @param id
 */
export function getDictFormData(id: number): AxiosPromise<DictForm> {
    return request({
        url: "/dict/" + id + "/form",
        method: "get",
    });
}

/**
 * 新增字典
 *
 * @param data
 */
export function addDict(data: DictForm) {
    return request({
        url: "/dict/value",
        method: "post",
        data: data,
    });
}

/**
 * 修改字典项
 *
 * @param id
 * @param data
 */
export function updateDict(id: number, data: DictForm) {
    return request({
        url: "/dict/" + id,
        method: "put",
        data: data,
    });
}

/**
 * 删除字典
 *
 * @param id 字典项ID，多个以英文逗号(,)分割
 */
export function deleteDict(id: string) {
    return request({
        url: "/dict/" + id,
        method: "delete",
    });
}
