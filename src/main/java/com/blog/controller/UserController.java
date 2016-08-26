package com.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.blog.model.User;
import com.blog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @package: com.blog.controller
 * @Author: 陈淼
 * @Date: 2016/6/4
 * @Description: 用户的控制类，用于拦截url为/user/*的所有请求
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //注册，若当前session已有用户信息，则不允许跳转注册页面
    @RequestMapping("/register")
    public String register(HttpSession session) {
        String loginUsername = (String) session.getAttribute("loginUsername");
        if (loginUsername != null && loginUsername != ""){
            return null;
        }
        return "user/userRegister";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user, HttpSession session)throws Exception{
        userService.saveUser(user);
        session.setAttribute("loginUsername", user.getUsername());
        return "redirect:/";
    }

    //登陆，若当前session已有用户信息，则不允许跳转登陆页面
    @RequestMapping("/login")
    public String login(HttpSession session){
        String loginUsername = (String) session.getAttribute("loginUsername");
        if (loginUsername != null && loginUsername != ""){
            return null;
        }
        return "user/userLogin";
    }

    //判断登陆页面所填写的用户信息是否存在，使用json传递结果
    @RequestMapping(value = "/exist", produces = "text/html;charset=UTF-8")
    public @ResponseBody String existUser(User user, HttpSession session) throws Exception{
        JSONObject userLogin = new JSONObject();
        //密码在UserService.exitUser中校验了
        boolean result = userService.existUser(user);
        userLogin.put("result", result);
        if (result){
            //result结果为真说明校验通过，获取用户相关信息，并将用户名写入session
            user = userService.findUserByName(user.getUsername());
            session.setAttribute("loginUsername", user.getUsername());
            //如果权限存在且权限不为空，则在session写入权限
            if (user.getPower() != null && user.getPassword() != ""){
                session.setAttribute("power", user.getPower());
            }
            System.out.println(userLogin.toJSONString());
            return userLogin.toJSONString();
        }else {
            return userLogin.toJSONString();
        }
    }

    //编辑用户信息
    @RequestMapping("/editUser")
    public String editUser(@RequestParam(value = "username", required = true) String username,
                           Model model, HttpSession session) throws Exception{
        //获取当前session的用户信息，若session内的loginUsername为空，则不允许范围编辑页面
        String loginUsername = (String) session.getAttribute("loginUsername");
        if (loginUsername != null){
            //若session内的loginUsername不为空，判别是否与正在访问的用户信息为同一人，若不是，不允许访问
            if (loginUsername.equals(username)){
                User user = userService.findUserByName(username);
                model.addAttribute("user", user);
                return "user/editUser";
            }else {
                return "redirect:/";
            }
        }
        return "redirect:/";
    }

    @RequestMapping("/updateUser")
    public String updateUser(Integer uid, User user)throws Exception{
        userService.updateUserById(uid, user);
        return "user/editUser";
    }

    //安全退出，移除session信息，并将该session设置为过期
    @RequestMapping("/userLogout")
    public String userLogout(HttpSession session){
        if (session.getAttribute("loginUsername")!=null){
            session.removeAttribute("loginUsername");
            session.invalidate();
        }
        return "redirect:/";
    }

    //列出用户列表
    @RequestMapping("/listUser")
    public String listUser(Model model,User user) throws Exception {
        List<User> users = userService.findUserByList(user);
        model.addAttribute("users", users);
        return "user/listUsers";
    }
}
