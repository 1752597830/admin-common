package com.qf.common.enmu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : sin
 * @date : 2024/1/16 15:08
 * @Description 枚举映射 EnumMap
 */
public class MenuEnum {
    public static Map<Integer, String> enumMap = new HashMap<>();

    // 填充键值对
    static {
        enumMap.put(1, "MENU");
        enumMap.put(2, "CATALOG");
        enumMap.put(3, "BUTTON");
    }
}
