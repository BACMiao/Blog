package com.blog.model;

import java.util.Date;

/**
 * Created by Black on 2016/5/28.
 */
public class Discuss {
    private int did;
    private int userId;
    private int articleId;
    private String ownId;
    private String parentId;
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

    @Override
    public String toString() {
        return "Discuss{" +
                "did=" + did +
                ", userId=" + userId +
                ", articleId=" + articleId +
                ", ownId='" + ownId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", message='" + message + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
