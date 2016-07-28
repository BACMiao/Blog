package com.blog.service;

import com.blog.model.Discuss;
import com.blog.model.DiscussCustom;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * Created by Black on 2016/6/8.
 */
public interface DiscussService {
    public void addDiscuss(Discuss discuss, HttpSession session, Integer articleId) throws Exception;
    public List<List> getAllDiscuss(Integer articleId) throws Exception;
    public int addReply(Discuss reply, HttpSession session, Integer did) throws Exception;
}
