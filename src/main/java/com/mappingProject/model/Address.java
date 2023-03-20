package com.mappingProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="address")
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(name="city")
	private String city;
	@Column(name="country")
	private String country;
	@Column(name="remarks")
	private String remarks;
	
	
	

}
