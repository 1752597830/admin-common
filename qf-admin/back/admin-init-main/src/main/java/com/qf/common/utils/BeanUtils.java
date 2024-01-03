package com.qf.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author : sin
 * @date : 2023/11/28 14:14
 * @Description : 获取容器中的Bean对象
 */
@Component
public class BeanUtils implements ApplicationContextAware {
    /**
     * 以静态变量保存ApplicationContext,可在任意代码中取出ApplicaitonContext.
     */
    private static ApplicationContext context;

    /**
     * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
     */
    @Override
    public void setApplicationContext(ApplicationContext context) {
        BeanUtils.context = context;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.  方法返回值的类型由调用者决定
     */
    public static <T> T getBean(String name) {
        return (T) context.getBean(name);
    }
    // 通过类名获取Bean对象
    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }


    /// 获取当前环境
    public String getActiveProfile() {
        return context.getEnvironment().getActiveProfiles()[0];
    }
}
