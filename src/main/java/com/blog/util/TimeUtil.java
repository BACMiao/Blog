package com.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @package: com.blog.util
 * @Author: 陈淼
 * @Date: 2016/6/6
 * @Description: 时间工具类，格式化时间的为自定义的格式
 */
public class TimeUtil {
    public TimeUtil() {}

    public static Date addTime() throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String a1 = dateformat.format(new Date());
        Date date = dateformat.parse(a1);
        return date;
    }
}
