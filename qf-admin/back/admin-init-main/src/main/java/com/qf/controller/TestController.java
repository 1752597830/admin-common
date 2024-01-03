package com.qf.controller;

import com.qf.server.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author : sin
 * @date : 2023/12/13 9:20
 * @Description :
 */
@RestController
@Tag(name = "测试")
public class TestController {
    @Autowired
    RedisTemplate redisTemplate;
    @GetMapping("/test")
    public Map<String, Object> test() throws Exception {

        // redis的相关信息
        // arch_bits：架构（32 或 64 位）
        // redis_version：版本
        // tcp_port：端口
        // uptime_in_days : 自 Redis 服务器启动以来，经过的天数
        // used_memory_human : 以人类可读的格式返回 Redis 分配的内存总量
        // persistence : RDB 和 AOF 的相关信息
        Properties info = (Properties) redisTemplate.execute((RedisCallback<Object>) connection -> connection.info());
        String archBits = info.getProperty("arch_bits");
        String redisVersion = info.getProperty("redis_version");
        String tcpPort = info.getProperty("tcp_port");
        String uptimeInDays = info.getProperty("uptime_in_days");
        String usedMemoryHuman = info.getProperty("used_memory_human");
        String persistence = info.getProperty("persistence");
        String cpu = info.getProperty("cpu");
        // key数量
        Object dbSize = redisTemplate.execute((RedisCallback<Object>) connection -> connection.dbSize());

        Map<String, Object> map = new HashMap<>();

        /**
         * @author: sin
         * @Description 获取服务器的相关信息
         */
        Server server = new Server();
        server.copyTo();
        map.put("server", server);
        map.put("archBits", archBits);
        map.put("redisVersion", redisVersion);
        map.put("tcpPort", tcpPort);
        map.put("uptimeInDays", uptimeInDays);
        map.put("usedMemoryHuman", usedMemoryHuman);
        map.put("info", info);
        map.put("key数量", dbSize);
        return map;
    }
}