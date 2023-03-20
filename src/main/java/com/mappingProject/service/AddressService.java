package com.mappingProject.service;

import java.util.List;

import com.mappingProject.model.Address;

public interface AddressService {
	Address save(Address address);
	
	Address update(Address address);
	
	void delete(Long id);
	
	Address getById(Long id);
	
	List<Address> getAllAddress();

}
