package com.blog.serviceImpl;

import com.blog.dao.DiscussDao;
import com.blog.dao.UserDao;
import com.blog.model.Discuss;
import com.blog.model.DiscussCustom;
import com.blog.model.User;
import com.blog.service.DiscussService;
import com.blog.util.TimeUtil;
import com.blog.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Black on 2016/6/8.
 */

@Service
public class DiscussServiceImpl implements DiscussService {

    DiscussDao discussDao;
    UserDao userDao;

    @Override
    public void addDiscuss(Discuss discuss, HttpSession session, Integer articleId) throws Exception {
        User user = userDao.findUserByName((String) session.getAttribute("loginUsername"));
        System.out.println(user.getUid());
        discuss.setUserId(user.getUid());
        discuss.setArticleId(articleId);
        discuss.setCreateTime(TimeUtil.addTime());
        discuss.setOwnId(UUIDGenerator.getUUID());
        discussDao.insertDiscuss(discuss);
    }

    @Override
    public List<List> getAllDiscuss(Integer articleId) throws Exception {
        List<DiscussCustom> discusses = discussDao.findDiscussUser(articleId);
        List<DiscussCustom> replies = new ArrayList<>();
        List<List> lists = new ArrayList<>();
        for(DiscussCustom ds : discusses ){
            if (ds.getParentId()!= null){
                replies.add(ds);
            }
        }
        discusses.removeAll(replies);
        lists.add(discusses);
        lists.add(replies);
        return lists;
    }

    @Override
    public int addReply(Discuss reply, HttpSession session, Integer parentId) throws Exception {
        User user = userDao.findUserByName((String) session.getAttribute("loginUsername"));
        Discuss discuss = discussDao.findDiscussById(parentId);
        reply.setUserId(user.getUid());
        reply.setArticleId(discuss.getArticleId());
        reply.setOwnId(UUIDGenerator.getUUID());
        reply.setParentId(discuss.getOwnId());
        reply.setCreateTime(TimeUtil.addTime());
        discussDao.insertDiscuss(reply);
        return discuss.getArticleId();
    }

    public DiscussDao getDiscussDao() {
        return discussDao;
    }

    @Autowired
    public void setDiscussDao(DiscussDao discussDao) {
        this.discussDao = discussDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
