package com.pet.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.adoption.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
