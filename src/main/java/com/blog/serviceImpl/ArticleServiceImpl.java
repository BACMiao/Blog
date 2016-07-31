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
import java.util.List;

/**
 * @package: com.blog.serviceImpl
 * @Author: 陈淼
 * @Date: 2016/6/6
 * @Description: 文章操作的服务的具体实现类
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    //使用spring注入
    private ArticleDao articleDao;
    private CategoryService categoryService;

    //根据文章名称查询文章是否存在，因为该博客中不允许文章名一模一样
    @Override
    public boolean existArticle(String title) throws Exception {
        List<ArticleCustom> article = articleDao.findArticleByTitle(title);
        //如果文章列表的长度不为0，则说明有相同名字的文章存在
        if (article.size()>0){
            return true;
        }
        return false;
    }

    //通过文章id来得到文章的具体内容，并返回一个经过markdown转化的文章内容
    @Override
    public String getArticle(Integer id, HttpServletRequest request) throws Exception {
        Article article = articleDao.findArticleById(id);
        //数据库的路径
        String Path = article.getArticlePath();
        //当前项目的实际路径
        String realPathDir = request.getSession().getServletContext().getRealPath("/");
        String articlePath = realPathDir + Path;
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
            //文章上传成功，给相应的类别下具有的文章数+1
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
