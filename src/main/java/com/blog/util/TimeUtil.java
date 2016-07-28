package com.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Created by Black on 2016/6/6.
 */
public class TimeUtil {
    public TimeUtil() {
    }

    public static Date addTime() throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String a1 = dateformat.format(new Date());
        Date date = dateformat.parse(a1);
        return date;
    }
}
