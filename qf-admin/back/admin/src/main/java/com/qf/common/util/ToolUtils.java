package com.qf.common.util;

/**
 * @author : sin
 * @date : 2024/1/14 17:08
 * @Description : 通用工具类
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
}