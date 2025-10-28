package com.project.practiceProject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.practiceProject.exception.ProductNotFoundException;
import com.project.practiceProject.model.Product;
import com.project.practiceProject.repository.ProductRepository;
import com.project.practiceProject.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();		
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Optional<Product> findById(long id) {
		return productRepository.findById(id);
	}
	
	public Optional<Product> findByName(String name){
		return productRepository.findByName(name);
	}
	
	public void deleteById(long id) {
		productRepository.deleteById(id);
	}
}
