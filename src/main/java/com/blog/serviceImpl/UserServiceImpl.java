package com.blog.serviceImpl;

import com.blog.dao.UserDao;
import com.blog.model.User;
import com.blog.service.UserService;
import com.blog.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by Black on 2016/5/31.
 */
@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Override
    public User findUserById(Integer uid) throws Exception {
        return userDao.findUserById(uid);
    }

    @Override
    public User findUserByName(String username) throws Exception {
        return userDao.findUserByName(username);
    }

    @Override
    public void updateUserById(Integer uid, User user) throws Exception {
        user.setUid(uid);
        User user1 = userDao.findUserById(uid);
        if (user.getPassword().equals(user1.getPassword())){
            userDao.updateUser(user);
        }else {
            user.setPassword(MD5.lock(user,user1.getSalt()));
            userDao.updateUser(user);
        }
    }

    @Override
    public void saveUser(User user) throws Exception {
        user.setPassword(MD5.lock(user));
        userDao.insertUser(user);
    }

    @Override
    public boolean existUser(User user) throws Exception {
        if (user.getUsername()!= null && user.getUsername()!= " "){
            User user1 = userDao.findUserByName(user.getUsername());
            if (user1!=null){
                //数据库中的用户密码（加密），故输入的密码也进行加密
                String password_input = MD5.lock(user,user1.getSalt());
                if (user1.getPassword().equals(password_input)){
                    return true;
                }
            }
        }
        return false;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
