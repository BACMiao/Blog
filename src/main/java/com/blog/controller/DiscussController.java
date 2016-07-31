package com.blog.controller;

import com.blog.model.Discuss;
import com.blog.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @package: com.blog.controller
 * @Author: 陈淼
 * @Date: 2016/6/4
 * @Description: 讨论的控制类，用于拦截url为/discuss/*的所有请求
 */
@Controller
@RequestMapping("/discuss")
public class DiscussController {

    @Autowired
    DiscussService discussService;

    //添加评论的处理，session为当前会话，具有当前访问站点的用户信息
    @RequestMapping("/add")
    public String addDiscuss(Discuss discuss, HttpSession session,
                             @RequestParam(value = "articleId") Integer articleId) throws Exception{
        discussService.addDiscuss(discuss, session, articleId);
        return "redirect:/article/viewArticle?id=" + articleId;
    }

    //添加回复的处理，parentId为当前回复的评论的id
    @RequestMapping("/reply")
    public String addReply(Discuss reply, HttpSession session,
                             @RequestParam(value = "parentId") Integer parentId) throws Exception{
        int articleId = discussService.addReply(reply, session, parentId);
        return "redirect:/article/viewArticle?id=" + articleId;
    }
}
