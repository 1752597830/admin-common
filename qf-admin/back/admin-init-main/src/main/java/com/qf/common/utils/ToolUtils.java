package com.qf.common.utils;

import com.qf.common.constant.Constant;
import com.wf.captcha.ArithmeticCaptcha;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author : sin
 * @date : 2023/12/13 13:14
 * @Description : 工具类
 */
public class ToolUtils {

    /**
     * 判断字符串是否包含指定的子字符串
     * @param str 字符串
     * @param args 子字符串
     * @return 若字符串包含指定的子字符串，则返回true；否则返回false
     */
    public static boolean contains(String str,String... args){
        for (String arg : args) {
            if(str.contains(arg)){
                return true;
            }
        }
        return false;
    }

    /**
     * 生成验证码
     */
    public static Map<String, String> GenerateVerifyCode() {
        UUID uuid = UUID.randomUUID();
        // 算术类型
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(130, 48);
        captcha.setLen(3);  // 几位数运算，默认是两位
        String result = captcha.text();  // 获取运算的结果：5
        // 存储到redis
        RedisCache redisCache = BeanUtils.getBean(RedisCache.class);
        redisCache.setCacheObject(Constant.REDIS_CAPTCHA_PREFIX + uuid, result);

        String base64 = captcha.toBase64();
        Map<String , String> map = new HashMap<>();
        map.put("captchaBase64", base64);
        map.put("captchaKey", String.valueOf(uuid));
        return map;
    }

}