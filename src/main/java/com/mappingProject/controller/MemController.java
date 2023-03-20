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
import com.mappingProject.model.Member;
import com.mappingProject.service.MemberService;

@ApiController

public class MemController {
	///////// Constructor Level autowired////////////
	private final MemberService memServ;
	public MemController(MemberService memServ) {
		this.memServ = memServ;
	}

	//////// Save Controller here ////////////
	@PostMapping("/save")
	public ResponseEntity<Member> save(@RequestBody Member member){
		Member mem = memServ.save(member);
		
		return new ResponseEntity<Member>(mem, HttpStatus.CREATED);
	}
	///////////// Update Controller here //////////
	@PutMapping("/update")
	public ResponseEntity<Member> updateMember(@RequestBody Member member){
		Member memUpdate = memServ.update(member);
		return new ResponseEntity<Member>(memUpdate, HttpStatus.OK); 
				
	}
	
	/////////////// Get single Member Controller here //////////////
	@GetMapping("/{id}")
	public ResponseEntity<Member> getMember(@PathVariable("id")Long id){
		Member memId = memServ.getById(id);
		
		return new ResponseEntity<Member>(memId, HttpStatus.OK);
	}
	
	////////////// Get all Member Controller here ///////////////
	@GetMapping("/member")
	public ResponseEntity<List<Member>> getAllMembers(){
		List<Member>memLis = memServ.getAllMembers();
		return new ResponseEntity<List<Member>>(memLis, HttpStatus.OK);
	}
//////////////Get Delete Member Controller here ///////////////
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMember(@PathVariable("id")Long id){
		Member memId = memServ.getById(id);
		
		return new ResponseEntity<String>(memId + " is deleted. ", HttpStatus.OK);
	}
	
}
