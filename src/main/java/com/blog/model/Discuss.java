package com.blog.model;

import java.util.Date;

/**
 * @package: com.blog.model
 * @Author: 陈淼
 * @Date: 2016/5/28
 * @Description: 评论的模型类
 */
public class Discuss {
    private int did;
    private int userId;      //发表评论的用户ID
    private int articleId;   //评论的文章的ID
    private String ownId;    //该评论的ID，其值为UUID所产生的随机值
    private String parentId; //该评论回复的评论的ID，其值为UUID所产生的随机值
    private String message;
    private Date createTime;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOwnId() {
        return ownId;
    }

    public void setOwnId(String ownId) {
        this.ownId = ownId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
