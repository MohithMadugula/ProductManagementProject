package com.project.practiceProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.practiceProject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	

	public Optional<Product> findByName(String name);
}
