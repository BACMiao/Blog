package com.blog.dao;

import com.blog.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @package: com.blog.dao
 * @Author: 陈淼
 * @Date: 2016/5/21
 * @Description: 用户的DAO接口类，与其对应的mapper文件为/mapper/UserMapper.xml
 */
@Repository
public interface UserDao {
    public User findUserById(int uid) throws Exception;
    public User findUserByName(String username) throws Exception;
    //暂未实现有用户相关信息查询用户的功能
    public List<User> findUserByList(User user) throws Exception;
    public void insertUser(User user) throws Exception;
    //暂时未实现删除用户功能
    public void deleteUserById(int uid) throws  Exception;
    public void updateUser(User user) throws Exception;
}
