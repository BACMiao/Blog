package com.blog.service;

import com.blog.model.User;

import java.util.List;

/**
 * @package: com.blog.service
 * @Author: 陈淼
 * @Date: 2016/6/1
 * @Description: 用户操作的服务接口
 */

public interface UserService {
    public User findUserById(Integer uid) throws Exception;
    public User findUserByName(String username) throws Exception;
    public List<User> findUserByList(User user) throws Exception;
    public void updateUserById(Integer uid, User user) throws Exception;
    public void saveUser(User user) throws Exception;
    public boolean existUser(User user)throws Exception;
}
