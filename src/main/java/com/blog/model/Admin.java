package com.blog.model;

/**
 * @package: com.blog.model
 * @Author: 陈淼
 * @Date: 2016/6/4
 * @Description: 管理员的模型类
 */
public class Admin {
    private int aid;
    private String username;
    private String password;


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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
}
