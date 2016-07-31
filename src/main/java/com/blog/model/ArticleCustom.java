package com.blog.model;

/**
 * @package: com.blog.model
 * @Author: 陈淼
 * @Date: 2016/6/11
 * @Description: 文章的自定义拓展模型类，增加了文章所对应类别名的属性
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
