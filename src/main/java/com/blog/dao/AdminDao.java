package com.blog.dao;

import com.blog.model.Admin;
import org.springframework.stereotype.Repository;

/**
 * Created by Black on 2016/5/21.
 **/
@Repository
public interface AdminDao {
    public Admin findAdminByList(Admin admin) throws Exception;
    public void updateAdminById(Admin admin) throws Exception;
}
