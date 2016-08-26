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
 * @package: com.blog.serviceImpl
 * @Author: 陈淼
 * @Date: 2016/6/8
 * @Description: 讨论操作的服务的具体实现类
 */
@Service
public class DiscussServiceImpl implements DiscussService {

    //使用spring注入
    DiscussDao discussDao;
    UserDao userDao;

    //评论的方法，只需要写入ownId即可
    @Override
    public void addDiscuss(Discuss discuss, HttpSession session, Integer articleId) throws Exception {
        //从session中获取当前评论的用户信息
        User user = userDao.findUserByName((String) session.getAttribute("loginUsername"));
        discuss.setUserId(user.getUid());
        discuss.setArticleId(articleId);
        discuss.setCreateTime(TimeUtil.addTime());
        discuss.setOwnId(UUIDGenerator.getUUID());
        discussDao.insertDiscuss(discuss);
    }

    //获取所有讨论，包括回复和评论
    @Override
    public List<List> getAllDiscuss(Integer articleId) throws Exception {
        //因为是通过articleId获取所有评论，所以回复和评论都是在一个list上，因此需要拆分成回复list和评论list
        List<DiscussCustom> discusses = discussDao.findDiscussUser(articleId);
        List<DiscussCustom> replies = new ArrayList<>();
        List<List> lists = new ArrayList<>();
        for(DiscussCustom ds : discusses ){
            //如果有parentId，说明这是一条回复，加到回复的list中
            if (ds.getParentId()!= null){
                replies.add(ds);
            }
        }
        //总list删去回复的list，剩下的即为评论的list
        discusses.removeAll(replies);
        //将两条list放入一个list中
        lists.add(discusses);
        lists.add(replies);
        return lists;
    }

    //回复的方法，因此在写入ownId的同时，也要写入当前回复的评论的ownId到自己的parentId
    @Override
    public int addReply(Discuss reply, HttpSession session, Integer parentId) throws Exception {
        //从session中获取当前评论的用户信息
        User user = userDao.findUserByName((String) session.getAttribute("loginUsername"));
        Discuss discuss = discussDao.findDiscussById(parentId);
        reply.setUserId(user.getUid());
        reply.setArticleId(discuss.getArticleId());
        //写入自身的标识ownId
        reply.setOwnId(UUIDGenerator.getUUID());
        //写入所回复的评论的id
        reply.setParentId(discuss.getOwnId());
        reply.setCreateTime(TimeUtil.addTime());
        discussDao.insertDiscuss(reply);
        return discuss.getArticleId();
    }

    @Override
    public void deleteDiscussByAid(Integer articleId) throws Exception {
        discussDao.deleteDiscussByAid(articleId);
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
