package com.blog.serviceImpl;

import com.blog.dao.CategoryDao;
import com.blog.model.Category;
import com.blog.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @package: com.blog.serviceImpl
 * @Author: 陈淼
 * @Date: 2016/6/5
 * @Description: 类别操作的服务的具体实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    //使用spring注入
    private CategoryDao categoryDao;

    @Override
    public Category findCategoryById(Integer cid) throws Exception {
        return categoryDao.findCategoryById(cid);
    }

    @Override
    public List<Category> findAllCategory() throws Exception {
        return categoryDao.findAllCategory();
    }

    //判断类别是否存在，一个博客中不应该存在相同的类别
    @Override
    public boolean existCategory(String categoryName) throws Exception {
       Category category = categoryDao.findCategoryByName(categoryName);
        if (category!=null && category.getCategoryName()!=""){
            return true;
        }
        return false;
    }

    @Override
    public boolean addCategory(Category category) throws Exception {
        if (existCategory(category.getCategoryName())){
            System.out.println("添加失败");
            return false;
        }
        else {
            categoryDao.insertCategory(category);
            System.out.println("添加成功");
            return true;
        }
    }

    //类别下文章的具体数量，将本身的数量+1再重新赋值并更新
    @Override
    public void categoryNumberUp(Category category) throws Exception {
        category.setNumber(category.getNumber()+1);
        updateCategory(category.getCid(),category);
    }

    //类别下文章的具体数量，将本身的数量-1再重新赋值并更新
    @Override
    public void categoryNumberDown(Category category) throws Exception {
        category.setNumber(category.getNumber()-1);
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
