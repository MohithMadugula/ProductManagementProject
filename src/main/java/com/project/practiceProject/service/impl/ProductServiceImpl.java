package com.project.practiceProject.service.impl;

import java.util.List;

import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.practiceProject.dto.ProductDTO;
import com.project.practiceProject.exception.ProductNotFoundException;
import com.project.practiceProject.model.Product;
import com.project.practiceProject.repository.ProductRepository;
import com.project.practiceProject.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	private ProductRepository productRepository;
	
	private ModelMapper modelMapper;
	
	public ProductServiceImpl(ProductRepository productRepository,ModelMapper modelMapper) {
		this.productRepository=productRepository;
		this.modelMapper=modelMapper;
	}

	public List<ProductDTO> getAllProducts(){
		return productRepository.findAll().stream().
				map(product -> modelMapper.map(product,ProductDTO.class)).
				collect(Collectors.toList());		
	}

	public ProductDTO createProduct(ProductDTO productDTO){
		Product product = modelMapper.map(productDTO,Product.class);
		Product created = productRepository.save(product);
		return modelMapper.map(created,ProductDTO.class);
	}
	
	public ProductDTO findById(long id) {
		Product product = productRepository.findById(id).
				orElseThrow(()-> new ProductNotFoundException("Product not fount with id: "+id));
		return modelMapper.map(product,ProductDTO.class);
	}
	
	public ProductDTO findByName(String name){
		Product product = productRepository.findByName(name).
				orElseThrow(()->new ProductNotFoundException("Porduct not found with name: "+name));
		return modelMapper.map(product, ProductDTO.class);
	}
	
	public String deleteById(long id) {
		productRepository.deleteById(id);
		return "Deleted Successfully";
	}



}
