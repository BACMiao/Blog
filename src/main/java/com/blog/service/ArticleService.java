package com.blog.service;

import com.blog.model.Article;
import com.blog.model.ArticleCustom;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @package: com.blog.service
 * @Author: 陈淼
 * @Date: 2016/6/6
 * @Description: 文章操作的服务接口
 */
public interface ArticleService {
    public boolean addArticle(Article article)throws Exception;
    public boolean existArticle(String title) throws Exception;
    public String getArticle(Integer id, HttpServletRequest request) throws Exception;
    public List<ArticleCustom> selectAllArticle()throws Exception;
    public Article selectArticleById(Integer id) throws Exception;
    public List<ArticleCustom> selectArticleByTitle(String title) throws Exception;
    public List<ArticleCustom> selectArticleByCid(Integer cid) throws Exception;
    public boolean deleteArticleById(Integer id, HttpServletRequest request) throws Exception;
}
