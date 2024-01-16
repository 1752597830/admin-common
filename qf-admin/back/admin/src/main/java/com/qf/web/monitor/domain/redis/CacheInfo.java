package com.qf.web.monitor.domain.redis;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * @author : sin
 * @date : 2024/1/16 21:34
 * @Description : 缓存信息
 */
@Schema(description = "缓存信息")
@Data
@ToString
public class CacheInfo {

    @Schema(description = "缓存名称")
    private String cacheName;

    @Schema(description = "缓存key")
    private String cacheKey;

    @Schema(description = "缓存值")
    private String cacheValue;

    @Schema(description = "备注")
    private String remark;

    public CacheInfo(String cacheName, String remark) {
        this.cacheName = cacheName;
        this.remark = remark;
    }
    public CacheInfo(String cacheName, String cacheKey, String cacheValue)
    {
        this.cacheName = StringUtils.replace(cacheName, ":", "");
        this.cacheKey = StringUtils.replace(cacheKey, cacheName+":", "");
        this.cacheValue = cacheValue;
    }
}