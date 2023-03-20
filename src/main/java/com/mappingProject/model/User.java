package com.mappingProject.model;

import java.util.List;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="Users")
public class User extends BaseModel {

	private String name;
	private String email;
	@NaturalId
	private String username;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	@ToString.Exclude
	private List<Role> roles;
}
