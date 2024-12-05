package com.task.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.task.entity.Category;

@Repository
public class CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<Category> getCategories(int page, int size) {
		Session session = null;
		List<Category> categories = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Category.class);
			criteria.setFirstResult(page * size);
			criteria.setMaxResults(size);
			categories = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return categories;
	}

	public Category createCategory(Category category) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(category);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				transaction.commit();
				session.close();
			}
		}
		return category;
	}

	public Category getCategoryById(int id) {
		Session session = null;
		Category category = null;
		try {
			session = sessionFactory.openSession();
			category = session.get(Category.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return category;
	}

	public Category updateCategoryById(int id, Category category) {
		Session session = null;
		Transaction transaction = null;
		Category ctgry = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			ctgry = session.get(Category.class, id);
			if (ctgry != null) {
				ctgry.setCid(category.getCid());
				ctgry.setCname(category.getCname());
				ctgry.setProducts(category.getProducts());
			}
			session.update(ctgry);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return ctgry;
	}

	public void deleteCategoryById(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Category category = session.get(Category.class, id);
			if (category != null) {
				session.delete(category);
				transaction.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
}
