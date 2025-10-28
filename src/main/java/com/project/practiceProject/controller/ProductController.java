package com.project.practiceProject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.practiceProject.exception.ProductNotFoundException;
import com.project.practiceProject.model.Product;
import com.project.practiceProject.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product postedProduct = productService.createProduct(product);
		return ResponseEntity.ok(postedProduct);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable long id ){
		Product product = productService.findById(id).
				orElseThrow(()-> new ProductNotFoundException("Product not found with id : "+id));
		return ResponseEntity.ok(product);
	}
	
	@GetMapping("/productByName/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name){
		Product product = productService.findByName(name).
				orElseThrow(()-> new ProductNotFoundException("Product not found with id : "+name));
		return ResponseEntity.ok(product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		productService.deleteById(id);
	}
	
	

	
	
	
}
