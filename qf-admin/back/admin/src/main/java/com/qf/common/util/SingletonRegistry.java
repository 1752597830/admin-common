package com.qf.common.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : sin
 * @date : 2024/1/16 11:28
 * @Description : 单例注册中心 懒汉式生成BCryptPasswordEncoder
 */
public class SingletonRegistry {
    private static final SingletonRegistry INSTANCE = new SingletonRegistry();
    private final Map<Class<?>, Object> singletonMap = new HashMap<>();

    private SingletonRegistry() {}

    public static SingletonRegistry getInstance() {
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    public <T> T getSingleton(Class<T> clazz) {
        synchronized (singletonMap) {
            if (!singletonMap.containsKey(clazz)) {
                try {
                    T instance = clazz.getDeclaredConstructor().newInstance();
                    singletonMap.put(clazz, instance);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to create a singleton instance for class: " + clazz.getName(), e);
                }
            }
            return (T) singletonMap.get(clazz);
        }
    }

    // 为PasswordEncoder提供一个便捷方法
    public BCryptPasswordEncoder getPasswordEncoder() {
        return getSingleton(BCryptPasswordEncoder.class);
    }

    // 假设我们已经有一个自定义的或第三方的PasswordEncoder实现类
    public void registerPasswordEncoder(BCryptPasswordEncoder encoder) {
        singletonMap.put(BCryptPasswordEncoder.class, encoder);
    }
}