package com.mappingProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mappingProject.model.Member;
import com.mappingProject.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	/////////////// Create Constructor Level autowired////////
	private final MemberRepository memRepo;
	
	public MemberServiceImpl(MemberRepository memRepo) {
		this.memRepo =memRepo;
	}

	@Override
	public Member save(Member member) {
		// TODO Auto-generated method stub
		return memRepo.save(member);
	}

	@Override
	public Member update(Member member) {
		// TODO Auto-generated method stub
		return memRepo.save(member);
	}

	@Override
	public void delete(Long id) {
	Member m = memRepo.findById(id).get();
	
	if(m == null) {
		return;
	}else {
		memRepo.delete(m);
	}
		
	}

	@Override
	public Member getById(Long id) {
		Member m = memRepo.findById(id).get();
		return m;
	}

	@Override
	public List<Member> getAllMembers() {
		List<Member> memberList =memRepo.findAll();
		return memberList;
	}

}
