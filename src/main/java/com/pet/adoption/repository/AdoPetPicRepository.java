package com.pet.adoption.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.adoption.model.AdoPet;
import com.pet.adoption.model.AdoPetPic;

public interface AdoPetPicRepository extends JpaRepository<AdoPetPic, Long> {

	List<AdoPetPic> findByAdoPetNo(Long adoPetNo);

	AdoPetPic findByAdoPetNoAndAdoPicNo(Long adoPetNo, Long adoPicNo);

}
