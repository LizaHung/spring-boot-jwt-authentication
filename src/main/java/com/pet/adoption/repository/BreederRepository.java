package com.pet.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.adoption.model.Breeder;

public interface BreederRepository extends JpaRepository<Breeder, Long> {

}
