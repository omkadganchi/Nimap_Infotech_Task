package com.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dao.ProductDao;
import com.task.entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;

	public List<Product> getProducts(int page, int size) {
		return productDao.getProducts(page, size);
	}

	public Product createProducts(Product product) {
		return productDao.createProducts(product);
	}

	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	public Product updateProductById(int id, Product product) {
		return productDao.updateProductById(id, product);
	}

	public void deleteProductById(int id) {
		productDao.deleteProductById(id);
	}

}
