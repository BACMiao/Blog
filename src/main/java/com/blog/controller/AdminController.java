package com.blog.controller;

import com.blog.model.Admin;
import com.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 *
 * Created by Black on 2016/6/4.
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

    @RequestMapping("/exist")
    public String existAdmin(Admin admin, HttpSession session) throws Exception{
        if (adminService.existAdmin(admin)){
            session.setAttribute("adminName", admin.getUsername());
            return "admin/success";
        }else {
            return "admin/failure";
        }
    }

    @RequestMapping("/adminLogout")
    public String adminLogout(HttpSession session){
        if (session.getAttribute("adminName")!=null){
            session.removeAttribute("adminName");
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
