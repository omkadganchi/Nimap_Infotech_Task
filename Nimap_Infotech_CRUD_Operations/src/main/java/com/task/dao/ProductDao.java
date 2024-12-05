package com.task.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.task.entity.Category;
import com.task.entity.Product;

@Repository
public class ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<Product> getProducts(int page, int size) {
		Session session = null;
		List<Product> products = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setFirstResult(page * size);
			criteria.setMaxResults(size);
			products = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return products;
	}

	public Product createProducts(Product product) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(product);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				transaction.commit();
				session.close();
			}
		}
		return product;
	}

	public Product getProductById(int id) {
		Session session = null;
		Product product = null;
		try {
			session = sessionFactory.openSession();
			product = session.get(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return product;
	}

	public Product updateProductById(int id, Product product) {
		Session session = null;
		Transaction transaction = null;
		Product prod = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			prod = session.get(Product.class, id);
			if (prod != null) {
				prod.setPid(product.getPid());
				prod.setPname(product.getPname());
				prod.setPrice(product.getPrice());
				prod.setCategory(product.getCategory());
			}
			session.update(prod);
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
		return prod;
	}

	public void deleteProductById(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Product product = session.get(Product.class, id);
			if (product != null) {
				session.delete(product);
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
