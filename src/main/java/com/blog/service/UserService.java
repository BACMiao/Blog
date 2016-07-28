package com.blog.service;

import com.blog.model.User;

/**
 *
 * Created by Black on 2016/6/1.
 */

public interface UserService {
    public User findUserById(Integer uid) throws Exception;
    public User findUserByName(String username) throws Exception;
    public void updateUserById(Integer uid, User user) throws Exception;
    public void saveUser(User user) throws Exception;
    public boolean existUser(User user)throws Exception;
}
