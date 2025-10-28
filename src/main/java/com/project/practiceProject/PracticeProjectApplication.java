package com.project.practiceProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.project.practiceProject.model.Product;
import com.project.practiceProject.repository.ProductRepository;

@SpringBootApplication
@EntityScan("com.project.practiceProject.model")
public class PracticeProjectApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PracticeProjectApplication.class, args);
	}


}
