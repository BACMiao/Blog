package com.blog.interceptor;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @package: com.blog.interceptor
 * @Author: 陈淼
 * @Date: 2016/7/27
 * @Description: springmvc拦截器，拦截所有url以/admin/**、/article/add*、/category/add*的请求
 */
public class AdminInterceptor implements org.springframework.web.servlet.HandlerInterceptor {

    //进入handler方法之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取用户访问的url地址
        String url = request.getRequestURI();
        //获取当前访问需拦截的url的会话，并得到所带有的权限
        HttpSession session = request.getSession();
        String power = (String) session.getAttribute("power");
        //验证权限是否不为空且为规定的权限
        if (power != null && power.equals("201421122049")){
            //若拥有权限，则检查该用户是否访问的是规定的页面url，若是则同意访问
            if (url.indexOf("admin/login") >= 0 || url.indexOf("admin/exist") >= 0){
                return true;
            }
        }
        //获取管理员的会话，若管理员的信息正确，则允许访问任何页面
        String adminName = (String) session.getAttribute("adminName");
        if (adminName != null){
            return true;
        }
        //若以上条件均不满足，则将页面重定向为初始页面
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }

    //进入handler方法之后，返回执行modelAndView方法之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    //执行完成handler之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
