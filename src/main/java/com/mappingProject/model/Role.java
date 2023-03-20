package com.mappingProject.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Role extends BaseModel {

	@NaturalId
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private List<User> users = new ArrayList<>();
	
}
