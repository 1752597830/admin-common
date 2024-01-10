import request from "@/utils/request";
import { AxiosPromise } from "axios";
export function getIcon(): AxiosPromise<object> {
    return request({
        url: "/getIcon",
        method: "get"
    })
}