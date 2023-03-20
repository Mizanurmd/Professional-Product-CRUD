package com.mappingProject.service;

import java.util.List;

import com.mappingProject.model.Member;

public interface MemberService {
	
	Member save(Member member);
	Member update(Member member);
	
	void delete(Long id);
	
	Member getById(Long id);
	
	List<Member> getAllMembers();

}
