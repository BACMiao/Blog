package com.blog.dao;

import com.blog.model.Discuss;
import com.blog.model.DiscussCustom;
import com.blog.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @package: com.blog.dao
 * @Author: 陈淼
 * @Date: 2016/5/28
 * @Description: 讨论的DAO接口类，与其对应的mapper文件为/mapper/DiscussMapper.xml
 */
@Repository
public interface DiscussDao {
    //根据文章aid查找并以创建的时间排序后返回该文章下的所有讨论信息
    public List<DiscussCustom> findDiscussUser(Integer articleId) throws Exception;
    public Discuss findDiscussById(Integer did) throws Exception;
    public void insertDiscuss(Discuss discuss) throws Exception;
    ////暂时未实现删除讨论功能
    public void deleteDiscussById(Integer did) throws  Exception;
}
