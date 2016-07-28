package com.blog.util;

import com.blog.model.User;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 *
 * Created by Black on 2016/7/22.
 */
public class MD5 {
    public MD5(){
    }

    public static String lock(User user){
        String algorithmName = "md5";
        String password = user.getPassword();
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        user.setSalt(salt);
        int hashIterations = 3;
        SimpleHash hash = new SimpleHash(algorithmName, password, salt, hashIterations);
        String encodedPassword = hash.toHex();
        return encodedPassword;
    }

    public static String lock(User user, String salt){
        String algorithmName = "md5";
        String password = user.getPassword();
        String salt1 = salt;
        int hashIterations = 3;
        SimpleHash hash = new SimpleHash(algorithmName, password, salt1, hashIterations);
        String encodedPassword = hash.toHex();
        return encodedPassword;
    }
}
