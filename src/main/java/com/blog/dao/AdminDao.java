package com.blog.dao;

import com.blog.model.Admin;
import org.springframework.stereotype.Repository;

/**
 * @package: com.blog.dao
 * @Author: 陈淼
 * @Date: 2016/5/21
 * @Description: 管理员的DAO接口类，与其对应的mapper文件为/mapper/AdminMapper.xml
 */
@Repository
public interface AdminDao {
    //通过用户名和密码获取管理员的信息
    public Admin findAdminByList(Admin admin) throws Exception;
    //根据aid更新管理员信息
    public void updateAdminById(Admin admin) throws Exception;
}
