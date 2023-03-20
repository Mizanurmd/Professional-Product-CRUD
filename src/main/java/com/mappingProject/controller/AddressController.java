package com.mappingProject.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mappingProject.apiConfig.ApiController;
import com.mappingProject.model.Address;
import com.mappingProject.service.AddressService;

@ApiController

public class AddressController {
	
	//////////// Create Constructor Level Auotwired ///////////////
	private final AddressService addServ;
	public AddressController(AddressService addServ) {
		this.addServ = addServ;
	}
	
	//////////////// Create save method for controller //////////
	@PostMapping("/address/save")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address){
		Address add = addServ.save(address);
		return new ResponseEntity<Address>(add, HttpStatus.CREATED);
	}
	
	///////////////// Create update controller here //////////
	@PutMapping("/address/update")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address){
		Address add = addServ.save(address);
		return new ResponseEntity<Address>(add, HttpStatus.OK);
	}
	
	/////////// create get single address here ////////////
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getAddress(@PathVariable("id") Long id){
		Address addId = addServ.getById(id);
		return new ResponseEntity<Address>(addId, HttpStatus.OK);
	}
	
	/////////////// get All Address controller here ========
	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAllAddress(){
		List<Address> addList = addServ.getAllAddress();
		return new ResponseEntity<List<Address>>(addList, HttpStatus.OK);
	}
	
	//////////////Delete address controller here ==========////////////
	@DeleteMapping("/address/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable("id")Long id){
		Address addId = addServ.getById(id);
		return new ResponseEntity<String>(addId + " is deleted. ", HttpStatus.OK);
	}

}
