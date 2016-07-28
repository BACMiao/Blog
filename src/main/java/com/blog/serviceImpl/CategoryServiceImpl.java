package com.blog.serviceImpl;

import com.blog.dao.CategoryDao;
import com.blog.model.Category;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Created by Black on 2016/6/5.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    @Override
    public Category findCategoryById(Integer cid) throws Exception {
        return categoryDao.findCategoryById(cid);
    }

    @Override
    public List<Category> findAllCategory() throws Exception {
        return categoryDao.findAllCategory();
    }

    @Override
    public boolean existCategory(String categoryName) throws Exception {
       Category category = categoryDao.findCategoryByName(categoryName);
        if (category!=null && category.getCategoryName()!=""){
            return true;
        }
        return false;
    }

    @Override
    public void addCategory(Category category) throws Exception {
        if (existCategory(category.getCategoryName())){
            System.out.println("添加失败");
        }
        else {
            categoryDao.insertCategory(category);
            System.out.println("添加成功");
        }
    }

    @Override
    public void categoryNumber(Category category) throws Exception {
        category.setNumber(category.getNumber()+1);
        updateCategory(category.getCid(),category);
    }

    @Override
    public void deleteCategory(Integer cid) throws Exception {
        categoryDao.deleteCategoryById(cid);
    }

    @Override
    public void updateCategory(Integer cid, Category category) throws Exception {
        category.setCid(cid);
        categoryDao.updateCategoryById(category);
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
}
