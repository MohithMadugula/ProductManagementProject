package com.project.practiceProject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.practiceProject.dto.ProductDTO;
import com.project.practiceProject.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProducts(){
		List<ProductDTO> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	
	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
		return ResponseEntity.ok(productService.createProduct(productDTO));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable long id ){
		return ResponseEntity.ok(productService.findById(id));
	}
	
	@GetMapping("/productByName/{name}")
	public ResponseEntity<ProductDTO> findByName(@PathVariable String name){
		return ResponseEntity.ok(productService.findByName(name));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id) {
		return ResponseEntity.ok(productService.deleteById(id));
	}
	
	

	
	
	
}
