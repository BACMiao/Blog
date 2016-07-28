package com.blog.util;

import org.markdown4j.Markdown4jProcessor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 *
 * Created by Black on 2016/6/6.
 */
public class MarkdownUtil {

    public MarkdownUtil() {
    }

    public static String read(String fileName) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null){
            sb.append(s + "\n");
        }
        in.close();
        String html = new Markdown4jProcessor().process(sb.toString());
        return html;
    }
}