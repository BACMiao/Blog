package com.blog.util;

import org.markdown4j.Markdown4jProcessor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @package: com.blog.util
 * @Author: 陈淼
 * @Date: 2016/6/6
 * @Description: markdown的工具类，用于将文件中的文章的markdown格式转化为html格式
 */
public class MarkdownUtil {

    public MarkdownUtil() {}

    public static String read(String fileName) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null){
            sb.append(s + "\n");
        }
        in.close();
        //使用Markdown4j进行转化
        String html = new Markdown4jProcessor().process(sb.toString());
        return html;
    }
}