package com.project.practiceProject.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
	
	@NotBlank(message="Name is required")
	private String name;
	
	@NotBlank(message="Description is required")
	private String description;
	
	@NotNull(message="price is required")
	@Positive(message="price must be greater than 0")
	private Double price;
	
	@NotNull(message="quantiy is required")
	@Min(value = 0,message="quantity must be greater than 0")
	private Integer quantity;

}
