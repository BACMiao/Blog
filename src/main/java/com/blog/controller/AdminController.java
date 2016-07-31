package com.blog.controller;

import com.blog.model.Admin;
import com.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @package: com.blog.controller
 * @Author: 陈淼
 * @Date: 2016/6/4
 * @Description: 管理员的控制类，用于拦截url为/admin/*的所有请求
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String login(){
        return "admin/adminLogin";
    }

    //提交登录信息后，判断用户信息是否存在，若存在则将管理员信息写入session并跳转至成功页面，否则跳转失败页面
    @RequestMapping("/exist")
    public String existAdmin(Admin admin, HttpSession session) throws Exception{
        if (adminService.existAdmin(admin)){
            session.setAttribute("adminName", admin.getUsername());
            return "admin/success";
        }else {
            return "admin/failure";
        }
    }

    //安全退出，移除session信息，并将该session设置为过期
    @RequestMapping("/adminLogout")
    public String adminLogout(HttpSession session){
        if (session.getAttribute("adminName")!=null){
            session.removeAttribute("adminName");
            session.invalidate();
        }
        return "redirect:/";
    }

    @RequestMapping("/tree")
    public String tree(){
        return "admin/tree";
    }

    @RequestMapping("/main")
    public String main(){
        return "admin/main";
    }

}
