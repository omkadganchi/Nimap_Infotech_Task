package com.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.dao.CategoryDao;
import com.task.entity.Category;

@Service
public class CategoryService {

	@Autowired
	CategoryDao categoryDao;

	public Category createCategory(Category category) {
		return categoryDao.createCategory(category);
	}

	public Category getCategoryById(int id) {
		return categoryDao.getCategoryById(id);
	}

	public List<Category> getCategories(int page, int size) {
		return categoryDao.getCategories(page, size);
	}

	public Category updateCategoryById(int id, Category category) {
		return categoryDao.updateCategoryById(id, category);
	}

	public void deleteCategoryById(int id) {
		categoryDao.deleteCategoryById(id);
	}
}
