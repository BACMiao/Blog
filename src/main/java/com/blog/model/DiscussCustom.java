package com.blog.model;

/**
 * @package: com.blog.model
 * @Author: 陈淼
 * @Date: 2016/5/28
 * @Description: 评论的自定义拓展模型类，增加了评论人姓名的属性
 */
public class DiscussCustom extends Discuss {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
