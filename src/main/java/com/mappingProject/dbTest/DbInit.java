package com.mappingProject.dbTest;

import org.springframework.context.annotation.Configuration;


import com.mappingProject.model.Address;
import com.mappingProject.model.Member;
import com.mappingProject.repository.AddressRepository;
import com.mappingProject.repository.MemberRepository;

import jakarta.annotation.PostConstruct;


@Configuration
public class DbInit {
	
	///////////// Constructor Level Autowired here ///////////////////
	private final MemberRepository meRepository;
	private final AddressRepository addRepo;
	
	public DbInit(MemberRepository meRepository, AddressRepository addRepo) {
		this.meRepository = meRepository;
		this.addRepo = addRepo;
	}
	//////////// This method is created for testing ////////////
	//@PostConstruct
	void initTest() {
		///////////// Create Address object here ///////////
		Address ad = new Address();
		ad.setCity("Dhaka");
		ad.setCountry("Bangladesh");
		ad.setRemarks("Cizen of Bangladesh");
		
		//ad = addRepo.save(ad);
		
		Member m = new Member();
		m.setName("Mizanur Rahman");
		m.setNidNo("0885582110");
		m.setRoomNo("01");
		m.setMobile("016082364244");
		m.setRemarks("Quait and good envir");
		m.setAddress(ad);
		
		 m = meRepository.save(m);
		 System.out.println("Member id : " + m.getId());
		 System.out.println("Address id : " + ad.getId());
		
	}
	

}
