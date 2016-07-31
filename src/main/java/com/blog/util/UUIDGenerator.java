package com.blog.util;

import java.util.UUID;

/**
 * @package: com.blog.util
 * @Author: 陈淼
 * @Date: 2016/6/5
 * @Description: uuid的生成的工具类
 */
public class UUIDGenerator {
    public UUIDGenerator() {}

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) +
                str.substring(19, 23) + str.substring(24);
        return temp;
    }
}
