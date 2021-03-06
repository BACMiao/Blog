package com.blog.service;

import com.blog.model.Discuss;
import com.blog.model.DiscussCustom;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @package: com.blog.service
 * @Author: 陈淼
 * @Date: 2016/6/8
 * @Description: 讨论操作的服务接口
 */
public interface DiscussService {
    public void addDiscuss(Discuss discuss, HttpSession session, Integer articleId) throws Exception;
    public List<List> getAllDiscuss(Integer articleId) throws Exception;
    public int addReply(Discuss reply, HttpSession session, Integer did) throws Exception;
    public void deleteDiscussByAid(Integer articleId) throws Exception;
}
