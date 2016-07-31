package com.blog.dao;

import com.blog.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @package: com.blog.dao
 * @Author: 陈淼
 * @Date: 2016/6/5
 * @Description: 类别的DAO接口类，与其对应的mapper文件为/mapper/CategoryMapper.xml
 */
@Repository
public interface CategoryDao {
    public Category findCategoryByName(String categoryName) throws Exception;
    public Category findCategoryById(Integer cid) throws Exception;
    //查找并返回所有类别信息
    public List<Category> findAllCategory() throws Exception;
    public void insertCategory(Category category) throws Exception;
    public void deleteCategoryById(Integer cid) throws  Exception;
    public void updateCategoryById(Category category) throws Exception;
}
