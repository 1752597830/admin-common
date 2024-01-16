package com.qf.web.monitor.controller;

import com.qf.common.constant.CacheConstants;
import com.qf.common.util.BaseResponse;
import com.qf.common.util.RedisCache;
import com.qf.web.monitor.domain.redis.CacheInfo;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * @author : sin
 * @date : 2024/1/16 18:53
 * @Description : 缓存监控
 */
@Tag(name = "05.缓存监控接口")
@RestController
@RequestMapping("/monitor/cache")
@Slf4j
public class CoachController {

    @Resource
    RedisCache redisCache;

    private final static List<CacheInfo> caches = new ArrayList<>();

    static {
        caches.add(new CacheInfo(CacheConstants.LOGIN_TOKEN_KEY, "用户信息"));
        caches.add(new CacheInfo(CacheConstants.SYS_CONFIG_KEY, "配置信息"));
        caches.add(new CacheInfo(CacheConstants.SYS_DICT_KEY, "数据字典"));
        caches.add(new CacheInfo(CacheConstants.CAPTCHA_CODE_KEY, "验证码"));
        caches.add(new CacheInfo(CacheConstants.REPEAT_SUBMIT_KEY, "防重提交"));
        caches.add(new CacheInfo(CacheConstants.RATE_LIMIT_KEY, "限流处理"));
        caches.add(new CacheInfo(CacheConstants.PWD_ERR_CNT_KEY, "密码错误次数"));
    }

    /**
     * 获取缓存名称
     * @return
     */
    @GetMapping("/getNames")
    public BaseResponse getCacheInfo() {
        return BaseResponse.success(caches);
    }

    /**
     * 获取指定name下的所有缓存key
     * @param cacheName
     * @return
     */
    @GetMapping("/getKeys/{cacheName}")
    public BaseResponse getCacheKeys(@PathVariable String cacheName) {
        Set<String> cacheKeys = redisCache.getKeysByName(cacheName + "*");
        List<Map<String, String>> list = new ArrayList<>();
        if (cacheKeys != null) {
            cacheKeys.forEach(key -> {
                Map<String, String> map = new HashMap<>();
                map.put("v", key);
                list.add(map);
            });
        }
        System.out.println(cacheKeys);
        return BaseResponse.success(list);
    }

    /**
     * 获取指定name下的指定key的缓存信息
     * @param cacheName
     * @param cacheKey
     * @return
     */
    @GetMapping("/getValue/{cacheName}/{cacheKey}")
    public BaseResponse getCacheValue(@PathVariable String cacheName, @PathVariable String cacheKey) {
        String cacheValue = redisCache.getCacheObject(cacheKey);
        CacheInfo cacheInfo = new CacheInfo(cacheName, cacheKey, cacheValue);
        return BaseResponse.success(cacheInfo);
    }

    /**
     * 清除指定name下的所有缓存信息
     * @param cacheName
     * @return
     */
    @DeleteMapping("/clearCacheName/{cacheName}")
    public BaseResponse clearCacheName(@PathVariable String cacheName) {
        Collection<String> cacheKeys = redisCache.keys(cacheName + "*");
        redisCache.deleteObject(cacheKeys);
        return BaseResponse.success();
    }

    /**
     * 清除指定key的缓存
     * @param cacheKey
     * @return
     */
    @DeleteMapping("/clearCacheKey/{cacheKey}")
    public BaseResponse clearCacheKey(@PathVariable String cacheKey) {
        redisCache.deleteObject(cacheKey);
        return BaseResponse.success();
    }

    /**
     * 清除整个redis的所有缓存
     * @return
     */
    @DeleteMapping("/clearCacheAll")
    public BaseResponse clearCacheAll() {
        Collection<String> cacheKeys = redisCache.keys("*");
        redisCache.deleteObject(cacheKeys);
        return BaseResponse.success();
    }

}