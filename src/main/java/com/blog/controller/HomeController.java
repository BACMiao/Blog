package com.blog.controller;

import com.blog.model.ArticleCustom;
import com.blog.model.Category;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @package: com.blog.controller
 * @Author: 陈淼
 * @Date: 2016/6/6
 * @Description:
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/")
    public String index(Model model) throws Exception {
        List<ArticleCustom> articles = articleService.selectAllArticle();
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("articles", articles);
        model.addAttribute("category", categories);
        return "index";
    }
}
