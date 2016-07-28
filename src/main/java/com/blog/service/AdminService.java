package com.blog.service;

import com.blog.model.Admin;

/**
 *
 * Created by Black on 2016/6/1.
 */

public interface AdminService {
    public void updateAdminById(Integer aid, Admin admin) throws Exception;
    public boolean existAdmin(Admin admin)throws Exception;
}
