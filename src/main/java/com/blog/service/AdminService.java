package com.blog.service;

import com.blog.model.Admin;

/**
 * @package: com.blog.service
 * @Author: 陈淼
 * @Date: 2016/6/1
 * @Description: 管理员操作的服务接口
 */
public interface AdminService {
    public void updateAdminById(Integer aid, Admin admin) throws Exception;
    public boolean existAdmin(Admin admin)throws Exception;
}
