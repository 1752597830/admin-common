package com.qf.common.util;

import com.qf.common.constant.CaptchaConstant;
import com.qf.common.constant.RedisConstant;
import com.wf.captcha.ArithmeticCaptcha;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : sin
 * @date : 2024/1/14 17:08
 * @Description : 通用工具类
 */
public class ToolUtils {
    /**
     * 判断字符串是否包含指定的子字符串
     *
     * @param str  字符串
     * @param args 子字符串
     * @return 若字符串包含指定的子字符串，则返回true；否则返回false
     */
    public static boolean contains(String str, String... args) {
        for (String arg : args) {
            if (str.contains(arg)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 生成图片验证码
     */
    public static Map<String, String> GenerateVerifyCode() {
        UUID uuid = UUID.randomUUID();
        // 算术类型
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(CaptchaConstant.CAPTCHA_IMAGE_WIDTH, CaptchaConstant.CAPTCHA_IMAGE_HEIGHT);
        captcha.setLen(CaptchaConstant.CAPTCHA_LENGTH);
        String result = captcha.text();
        RedisCache redisCache = BeanUtils.getBean(RedisCache.class);
        redisCache.setCacheObject(RedisConstant.REDIS_CAPTCHA_PREFIX + uuid, result);
        String base64 = captcha.toBase64();
        Map<String, String> map = new HashMap<>();
        map.put(CaptchaConstant.CAPTCHA_KEY, String.valueOf(uuid));
        map.put(CaptchaConstant.CAPTCHA_BASE64, base64);
        return map;
    }
    /**
     * @author: sin
     * @Description 增删改 判断 是否成功
     */
    public static boolean isOk(int rows) {
        return rows > 0;
    }

    /**
     * @param ids
     * @Description: 根据字符串获取Long集合
     * @return
     */
    public static List<Long> getLongListByString(String ids) {
        if(ids == null || ids.length() == 0) {
            return null;
        }
        return Arrays.stream(ids.split(",")).map(Long::valueOf).collect(Collectors.toList());
    }

    /**
     * @param list1
     * @param list2
     * @Description: 判断list1是否包含list2
     * @return
     */
    public static<T> boolean isContain(List<T> list1, List<T> list2) {
        if(list1 == null && list2 != null) {
            return false;
        }
        if(list2 == null) {
            return true;
        }
        return list2.stream().allMatch(list1::contains);
    }
}