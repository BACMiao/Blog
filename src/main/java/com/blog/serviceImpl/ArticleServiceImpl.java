package com.blog.serviceImpl;

import com.blog.dao.ArticleDao;
import com.blog.model.Article;
import com.blog.model.ArticleCustom;
import com.blog.model.Category;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.blog.util.MarkdownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Black on 2016/6/6.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao;
    private CategoryService categoryService;

    @Override
    public boolean existArticle(String title) throws Exception {
        List<ArticleCustom> article = articleDao.findArticleByTitle(title);
        for (Article art: article){
            if (art!=null && art.getTitle()!=""){
                return true;
            }
        }
        return false;
    }

    @Override
    public String getArticle(Integer id, HttpServletRequest request) throws Exception {
        Article article = articleDao.findArticleById(id);
        //数据库的路径
        String Path = article.getArticlePath();
        String realPathDir = request.getSession().getServletContext().getRealPath("/");
        String articlePath = realPathDir + Path;
        System.out.println(articlePath);
        String blog = MarkdownUtil.read(articlePath);
        return blog;
    }

    @Override
    public List<ArticleCustom > selectAllArticle() throws Exception {
        return articleDao.findAllArticle();
    }

    @Override
    public Article selectArticleById(Integer id) throws Exception {
        return articleDao.findArticleById(id);
    }

    @Override
    public List<ArticleCustom> selectArticleByTitle(String title) throws Exception {
        return articleDao.findArticleByTitle(title);
    }

    @Override
    public List<ArticleCustom> selectArticleByCid(Integer cid) throws Exception {
        return articleDao.findArticleByCid(cid);
    }

    @Override
    public void addArticle(Article article) throws Exception {
        if (existArticle(article.getTitle())) {
            System.out.println("文件存在");
        }
        else {
            System.out.println("上传成功");
            Category category = categoryService.findCategoryById(article.getCategoryId());
            categoryService.categoryNumber(category);
            articleDao.insertArticle(article);
        }
    }

    public ArticleDao getArticleDao() {
        return articleDao;
    }

    @Autowired
    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
