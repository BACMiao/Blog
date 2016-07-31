package com.blog.util;

import com.blog.model.User;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @package: com.blog.util
 * @Author: 陈淼
 * @Date: 2016/7/22
 * @Description: MD5加密工具类
 */
public class MD5 {
    public MD5(){
    }

    //新用户的加密，其中的salt为随机产生的值
    public static String lock(User user){
        String algorithmName = "md5";
        String password = user.getPassword();
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        user.setSalt(salt);
        int hashIterations = 3;    //加密次数为3次
        SimpleHash hash = new SimpleHash(algorithmName, password, salt, hashIterations);
        String encodedPassword = hash.toHex();
        return encodedPassword;
    }

    //根据给定的salt对密码进行加密
    public static String lock(User user, String salt){
        String algorithmName = "md5";
        String password = user.getPassword();
        String salt1 = salt;
        int hashIterations = 3;    //加密次数为3次
        SimpleHash hash = new SimpleHash(algorithmName, password, salt1, hashIterations);
        String encodedPassword = hash.toHex();
        return encodedPassword;
    }
}
