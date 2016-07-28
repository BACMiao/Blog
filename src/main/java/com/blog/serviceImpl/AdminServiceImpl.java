package com.blog.serviceImpl;

import com.blog.dao.AdminDao;
import com.blog.model.Admin;
import com.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by Black on 2016/6/4.
 */

@Service
public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao;

    @Override
    public void updateAdminById(Integer aid, Admin admin) throws Exception {
        admin.setAid(aid);
        adminDao.updateAdminById(admin);
    }

    @Override
    public boolean existAdmin(Admin admin) throws Exception {
        if (admin.getUsername()!= null && admin.getUsername()!= " " &&
                admin.getPassword()!=null && admin.getPassword()!=" "){
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
