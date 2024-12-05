package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.entity.Product;
import com.task.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getProducts(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "3")int size){
		return productService.getProducts(page, size);
	}
	
	@PostMapping
	public Product createProducts(@RequestBody Product product) {
		return productService.createProducts(product);
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@PutMapping("/{id}")
	public Product updateProductById(@PathVariable int id, @RequestBody Product product) {
		return productService.updateProductById(id, product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable int id) {
		productService.deleteProductById(id);
	}
}
