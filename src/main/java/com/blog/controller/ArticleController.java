package com.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.blog.model.Article;
import com.blog.model.ArticleCustom;
import com.blog.model.Category;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.blog.service.DiscussService;
import com.blog.util.TimeUtil;
import com.blog.util.UploadUtil;
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
 *
 * Created by Black on 2016/6/6.
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

    @RequestMapping("/add")
    public String add(){
        return "article/add";
    }

    @RequestMapping("/addArticle")
    public String addArticle(@RequestParam("file") CommonsMultipartFile file,
                              Article article, HttpServletRequest request) throws Exception {
        article.setCreateTime(TimeUtil.addTime());
        article.setArticlePath(UploadUtil.upload(file, article, request));
        articleService.addArticle(article);
        return "article/success";
    }

    @RequestMapping("/viewArticle")
    public String viewArticle(@RequestParam(value = "id", required = true) Integer id,
                              Model model) throws Exception {
        Article article = articleService.selectArticleById(id);
        List<List> lists = discussService.getAllDiscuss(id);
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("discuss", lists.get(0));
        model.addAttribute("reply", lists.get(1));
        model.addAttribute("article", article);
        model.addAttribute("category", categories);
        return "article/viewArticle";
    }

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
}
