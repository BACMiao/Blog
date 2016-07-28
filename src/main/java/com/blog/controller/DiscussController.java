package com.blog.controller;

import com.blog.model.Discuss;
import com.blog.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 *
 * Created by Black on 2016/6/9.
 */
@Controller
@RequestMapping("/discuss")
public class DiscussController {

    @Autowired
    DiscussService discussService;

    @RequestMapping("/add")
    public String addDiscuss(Discuss discuss, HttpSession session,
                             @RequestParam(value = "articleId") Integer articleId) throws Exception{
        discussService.addDiscuss(discuss, session, articleId);
        return "redirect:/article/viewArticle?id=" + articleId;
    }

    @RequestMapping("/reply")
    public String addReply(Discuss reply, HttpSession session,
                             @RequestParam(value = "parentId") Integer parentId) throws Exception{
        int articleId = discussService.addReply(reply, session, parentId);
        return "redirect:/article/viewArticle?id=" + articleId;
    }
}
