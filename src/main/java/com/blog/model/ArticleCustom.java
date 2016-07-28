package com.blog.model;

/**
 *
 * Created by Black on 2016/6/11.
 */
public class ArticleCustom extends Article {
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
