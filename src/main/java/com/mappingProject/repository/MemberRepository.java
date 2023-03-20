package com.mappingProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mappingProject.model.Member;

@Repository
public interface MemberRepository  extends JpaRepository<Member, Long> {

}
