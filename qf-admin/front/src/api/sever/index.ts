import request from "@/utils/request";
import { AxiosPromise } from "axios";
import { severData } from "./types";
/**
 * 获取服务监控数据
 *
 */
export function getSever(): AxiosPromise<severData> {
    return request({
        url: "/sever/a",
        method: "get"
    })
}