package com.blog.model;

import java.util.Date;

/**
 * @package: com.blog.model
 * @Author: 陈淼
 * @Date: 2016/6/4
 * @Description: 文章的模型类
 */
public class Article {
    private int id;
    private String title;
    private Date createTime;
    private String articlePath;     //文章存储的文件路径
    private int categoryId;         //该文章所对应的类别的ID
    private String articleDescribe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getArticlePath() {
        return articlePath;
    }

    public void setArticlePath(String articlePath) {
        this.articlePath = articlePath;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getArticleDescribe() {
        return articleDescribe;
    }

    public void setArticleDescribe(String articleDescribe) {
        this.articleDescribe = articleDescribe;
    }

}
