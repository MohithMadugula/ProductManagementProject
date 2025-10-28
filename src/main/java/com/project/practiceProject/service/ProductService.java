package com.project.practiceProject.service;

import java.util.List;
import java.util.Optional;

import com.project.practiceProject.model.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public Product createProduct(Product product);
	public Optional<Product> findById(long id);
	public Optional<Product> findByName(String name);
	public void deleteById(long id);
}
