package com.project.practiceProject.service;

import java.util.List;

import com.project.practiceProject.dto.ProductDTO;

public interface ProductService {
	public List<ProductDTO> getAllProducts();
	public ProductDTO createProduct(ProductDTO productDTO);
	public ProductDTO findById(long id);
	public ProductDTO findByName(String name);
	public String deleteById(long id);
}
