package com.mappingProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name="product")
public class Product extends BaseModel {
	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private Double price;
	private String description;

}
