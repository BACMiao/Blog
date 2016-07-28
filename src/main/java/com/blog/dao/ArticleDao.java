package com.blog.dao;

import com.blog.model.Article;
import com.blog.model.ArticleCustom;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * Created by Black on 2016/6/4.
 */
@Repository
public interface ArticleDao {
    public Article findArticleById(int id) throws Exception;
    public List<ArticleCustom> findArticleByTitle(String title) throws Exception;
    public List<Article> findArticleByList(Article article) throws Exception;
    public List<ArticleCustom> findAllArticle() throws Exception;
    public List<ArticleCustom> findArticleByCid(int cid) throws Exception;
    public void insertArticle(Article article) throws Exception;
    public void deleteArticleById(int id) throws  Exception;
    public void updateArticleById(Article article) throws Exception;
}
