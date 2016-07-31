package com.blog.model;

import java.io.Serializable;

/**
 * @package: com.blog.model
 * @Author: 陈淼
 * @Date: 2016/5/21
 * @Description: 用户的模型类
 */
public class User implements Serializable{
    private int uid;
    private String username;
    private String password;
    private String salt;      //盐，用于密码加密
    private String power;     //权限

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
