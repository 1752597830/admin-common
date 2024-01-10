import request from "@/utils/request";
import { AxiosPromise } from "axios";

// 查询缓存名称列表
export function listCacheName(): AxiosPromise<object> {
    return request({
        url: '/monitor/cache/getNames',
        method: "get"
    })
}
// 查询缓存键名列表
export function listCacheKey(cacheName: string): AxiosPromise<object> {
    return request({
        url: '/monitor/cache/getKeys/' + cacheName,
        method: 'get'
    })
}
// 查询缓存内容
export function getCacheValue(cacheName: string, cacheKey: string): AxiosPromise<object> {
    return request({
        url: '/monitor/cache/getValue/' + cacheName + '/' + cacheKey,
        method: 'get'
    })
}

// 清理指定名称缓存
export function clearCacheName(cacheName: string): AxiosPromise<object> {
    return request({
        url: '/monitor/cache/clearCacheName/' + cacheName,
        method: 'delete'
    })
}
// 清理指定键名缓存
export function clearCacheKey(cacheKey:string): AxiosPromise<object> {
    return request({
      url: '/monitor/cache/clearCacheKey/' + cacheKey,
      method: 'delete'
    })
  }
  
  // 清理全部缓存
  export function clearCacheAll(): AxiosPromise<object> {
    return request({
      url: '/monitor/cache/clearCacheAll',
      method: 'delete'
    })
  }