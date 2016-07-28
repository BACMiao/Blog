package com.blog.interceptor;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 测试拦截器
 * Created by Black on 2016/7/27.
 */
public class AdminInterceptor implements org.springframework.web.servlet.HandlerInterceptor {

    //进入handler方法之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();

        HttpSession session = request.getSession();
        String power = (String) session.getAttribute("power");
        if (power != null && session.getAttribute("power").equals("201421122049")){
            if (url.indexOf("admin/login")>=0||url.indexOf("admin/exist")>=0){
                return true;
            }
        }
        String adminName = (String) session.getAttribute("adminName");
        if (adminName != null){
            return true;
        }
        request.getRequestDispatcher("/").forward(request,response);
        return true;
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
