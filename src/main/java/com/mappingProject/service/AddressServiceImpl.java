package com.mappingProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mappingProject.model.Address;
import com.mappingProject.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	////////////// Constructor level Autowired here ///////////////
	private final AddressRepository addRepo;
	
	public AddressServiceImpl(AddressRepository addRepo) {
		this.addRepo= addRepo;
	}

	@Override
	public Address save(Address address) {
		// TODO Auto-generated method stub
		return addRepo.save(address);
	}

	@Override
	public Address update(Address address) {
		// TODO Auto-generated method stub
		return addRepo.save(address);
	}

	@Override
	public void delete(Long id) {
		Address addr = addRepo.findById(id).get();
		
		if(addr == null) {
			return;
		}else {
			addRepo.delete(addr);
		}
		
		
	}

	@Override
	public Address getById(Long id) {
		Address addId = addRepo.findById(id).get();
		return addId;
	}

	@Override
	public List<Address> getAllAddress() {
		List<Address>addList = addRepo.findAll();
		return addList;
	}


}
