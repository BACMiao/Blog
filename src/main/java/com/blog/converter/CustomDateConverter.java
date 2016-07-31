package com.blog.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @package: com.blog.converter
 * @Author: 陈淼
 * @Date: 2016/6/1
 * @Description: springMVC的自定义类型转换器，将输入的日期格式化为我们要求的格式
 */
public class CustomDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //如果参数绑定失败，则返回空
        return null;
    }
}
