package com.mappingProject.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="member")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String nidNo;
	private String roomNo;
	private String mobile;
	private String remarks;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id", referencedColumnName = "id")
	private Address address;

	

	
	
	

}
