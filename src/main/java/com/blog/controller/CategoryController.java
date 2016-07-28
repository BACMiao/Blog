package com.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.blog.model.Category;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * Created by Black on 2016/6/5.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/add")
    public String add(){
        return "category/add";
    }

    @RequestMapping("/addCategory")
    public String addCategory(Category category) throws Exception {
        categoryService.addCategory(category);
        return "category/success";
    }

    @RequestMapping(value = "/findAllCategory", produces = "text/html;charset=UTF-8")
    public @ResponseBody String findAllCategory() throws Exception {
        List<Category> categories = categoryService.findAllCategory();
        JSONObject categoryMsg = new JSONObject();
        categoryMsg.put("categories", categories);
        System.out.println(categoryMsg.toString());
        return categoryMsg.toJSONString();
    }
}
