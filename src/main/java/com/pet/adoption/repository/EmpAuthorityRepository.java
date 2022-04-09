package com.pet.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.adoption.model.EmpAuthority;

public interface EmpAuthorityRepository extends JpaRepository<EmpAuthority, Long> {

}
