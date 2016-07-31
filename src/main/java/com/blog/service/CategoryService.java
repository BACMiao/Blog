package com.blog.service;

import com.blog.model.Category;

import java.util.List;

/**
 * @package: com.blog.service
 * @Author: 陈淼
 * @Date: 2016/6/5
 * @Description: 类别操作的服务接口
 */
public interface CategoryService {
    public Category findCategoryById(Integer cid) throws Exception;
    public List<Category> findAllCategory() throws Exception;
    public boolean existCategory(String categoryName) throws Exception;
    public void addCategory(Category category) throws Exception;
    public void categoryNumber(Category category) throws Exception;
    public void deleteCategory(Integer cid) throws Exception;
    public void updateCategory(Integer cid, Category category) throws Exception;
}
