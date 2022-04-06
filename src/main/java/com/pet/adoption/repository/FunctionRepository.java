package com.pet.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.adoption.model.BackFunction;

public interface FunctionRepository extends JpaRepository<BackFunction, String> {

}
