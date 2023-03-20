package com.mappingProject.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {
	@NotEmpty(message = "Name is mandatory")
	private String name;
	@NotNull(message = "Price is mandatory")
	private Double price;
	private String description;

}
