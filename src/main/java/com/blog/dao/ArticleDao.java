package com.blog.dao;

import com.blog.model.Article;
import com.blog.model.ArticleCustom;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @package: com.blog.dao
 * @Author: 陈淼
 * @Date: 2016/6/4
 * @Description: 文章的DAO接口类，与其对应的mapper文件为/mapper/ArticleMapper.xml
 */
@Repository
public interface ArticleDao {
    public Article findArticleById(int id) throws Exception;
    //根据文章名查找文章详细信息，除返回文章信息外，还会返回categoryName（类别名）
    public List<ArticleCustom> findArticleByTitle(String title) throws Exception;
    //查找并以创建文章时间的倒序返回所有文章信息以及相对于的categoryName
    public List<ArticleCustom> findAllArticle() throws Exception;
    //根据类别cid查找该类下所有文章信息
    public List<ArticleCustom> findArticleByCid(int cid) throws Exception;
    public void insertArticle(Article article) throws Exception;
    //根据文章id删除文章
    public void deleteArticleById(int id) throws  Exception;
    //暂时未实现更新文章功能
    public void updateArticleById(Article article) throws Exception;
}
