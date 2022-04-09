package com.pet.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.adoption.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
