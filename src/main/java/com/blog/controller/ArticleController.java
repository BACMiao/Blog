package com.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.blog.model.Article;
import com.blog.model.ArticleCustom;
import com.blog.model.Category;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.blog.service.DiscussService;
import com.blog.util.TimeUtil;
import com.blog.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @package: com.blog.controller
 * @Author: 陈淼
 * @Date: 2016/6/6
 * @Description: 文章的控制类，用于拦截url为/article/*的所有请求
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private DiscussService discussService;
    @Autowired
    CategoryService categoryService;

    //跳转至添加信息的界面
    @RequestMapping("/add")
    public String add(Model model) throws Exception {
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("category", categories);
        return "article/add";
    }

    //处理添加文章
    @RequestMapping("/addArticle")
    public String addArticle(@RequestParam("file") CommonsMultipartFile file,
                              Article article, HttpServletRequest request) throws Exception {
        //格式化添加时间
        article.setCreateTime(TimeUtil.addTime());
        //将文章的存储路径写入文章属性中
        article.setArticlePath(FileUtil.upload(file, article, request));
        articleService.addArticle(article);
        return "redirect:/article/listArticle";
    }

    //列出文章列表
    @RequestMapping("/listArticle")
    public String listArticle(Model model) throws Exception {
        List<ArticleCustom> articles = articleService.selectAllArticle();
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("articles", articles);
        model.addAttribute("category", categories);
        return "article/listArticles";
    }

    //传递与文章相关的信息，包括评论、回复、类别等，参数id为文章的id
    @RequestMapping("/viewArticle")
    public String viewArticle(@RequestParam(value = "id", required = true) Integer id,
                              Model model) throws Exception {
        //获取特定id的文章信息，但不包括正文
        Article article = articleService.selectArticleById(id);
        //获取所有评论、回复、类别，写入到model中传递到特定页面
        List<List> lists = discussService.getAllDiscuss(id);
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("discuss", lists.get(0)); //lists中第一个list为评论
        model.addAttribute("reply", lists.get(1));   //lists中第二个list为回复
        model.addAttribute("article", article);
        model.addAttribute("category", categories);
        return "article/viewArticle";
    }

    //传递文章正文，使用json的方法
    @RequestMapping(value="/json", produces = "text/html;charset=UTF-8")
    public @ResponseBody String jsonArticle(@RequestParam(value = "id", required = true)Integer id,
                                         HttpServletRequest request) throws Exception {
        String msg = articleService.getArticle(id, request);
        JSONObject article = new JSONObject();
        article.put("msg", msg);
        System.out.println(article.toString());
        return article.toJSONString();
    }

    @RequestMapping("/findArticleByTitle")
    public String findArticleByTitle(@RequestParam(value = "title", required = true) String title,
                                     Model model) throws Exception {
        List<ArticleCustom> articleCustoms = articleService.selectArticleByTitle(title);
        model.addAttribute("articleCustoms", articleCustoms);
        return "article/findArticle";
    }

    //替换方法，还未用上
    @RequestMapping(value = "/findAllArticle", produces = "text/html;charset=UTF-8")
    public @ResponseBody String findAllArticle() throws Exception {
        List<ArticleCustom> articles = articleService.selectAllArticle();
        JSONObject articleMsg = new JSONObject();
        articleMsg.put("articles", articles);
        System.out.println(articleMsg.toString());
        return articleMsg.toJSONString();
    }

    @RequestMapping(value = "/findArticleByCid")
    public String findArticleByCid(@RequestParam(value = "cid", required = true) int cid,
                                   Model model) throws Exception {
        List<ArticleCustom> articlesByCid = articleService.selectArticleByCid(cid);
        model.addAttribute("articlesByCid", articlesByCid);
        return "article/findArticleByCid";
    }

    //删除文章，并返回json数据
    @RequestMapping(value = "/deleteArticle", produces = "text/html;charset=UTF-8")
    public @ResponseBody String deleteArticleById(@RequestParam(value = "id", required = true) int id,
                                                  HttpServletRequest request) throws Exception {
        JSONObject deleteArticle = new JSONObject();
        boolean result = articleService.deleteArticleById(id, request);
        deleteArticle.put("result", result);
        System.out.println(deleteArticle.toJSONString());
        return deleteArticle.toJSONString();
    }
}
