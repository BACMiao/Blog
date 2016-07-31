package com.blog.model;

/**
 * @package: com.blog.model
 * @Author: 陈淼
 * @Date: 2016/6/4
 * @Description: 文章类型的模型类
 */
public class Category {
    private int cid;
    private String categoryName;
    private int number;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", categoryName='" + categoryName + '\'' +
                ", number=" + number +
                '}';
    }
}
