package com.blog.serviceImpl;

import com.blog.dao.AdminDao;
import com.blog.model.Admin;
import com.blog.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @package: com.blog.serviceImpl
 * @Author: 陈淼
 * @Date: 2016/6/4
 * @Description: 管理员操作的服务的具体实现类
 */
@Service
public class AdminServiceImpl implements AdminService {

    //使用spring注入
    private AdminDao adminDao;

    //根据id更新管理员信息
    @Override
    public void updateAdminById(Integer aid, Admin admin) throws Exception {
        admin.setAid(aid);
        adminDao.updateAdminById(admin);
    }

    //判断当前访问的管理员信息是否存在
    @Override
    public boolean existAdmin(Admin admin) throws Exception {
        if (admin.getUsername()!= null && admin.getUsername() !=  " " &&
                admin.getPassword()!= null && admin.getPassword() != " "){
            // 直接通过客户端发给服务器的信息查询数据库，因为在数据库级别进行验证，因此不用判别密码是否正确
            //如果数据库找不到密码和用户名都正确的账户，则返回false
            if (adminDao.findAdminByList(admin) != null){
                return true;
            }
            return false;
        }
        return false;
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }

    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
}
