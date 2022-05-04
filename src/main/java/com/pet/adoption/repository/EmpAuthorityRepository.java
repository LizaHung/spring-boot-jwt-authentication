package com.pet.adoption.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pet.adoption.model.EmpAuthority;
import com.pet.adoption.model.EmpAuthorityId;

public interface EmpAuthorityRepository extends JpaRepository<EmpAuthority, EmpAuthorityId> {

	List<EmpAuthority> findByEmpNo(Long empNo);
}
