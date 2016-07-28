package com.blog.model;

/**
 *
 * Created by Black on 2016/6/4.
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
