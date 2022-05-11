package com.pet.adoption.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pet.adoption.common.AdoStatusEnum;
import com.pet.adoption.dto.param.AdoPetParam;
import com.pet.adoption.model.AdoPet;

public interface AdoPetRepository extends JpaRepository<AdoPet, Long> {

	AdoPet findByAdoPetNo(Long adoPetNo);

	List<AdoPet> findByAdoStatus(AdoStatusEnum adostatus);

//	Optional<List<AdoPet>> findByMemberOrderByAdoStatus(Member member);
//
//	List<AdoPet> findByMember(Member memNo);

	AdoPet save(AdoPetParam adoPet);

	@Query("select adopet from ado_pet adopet where "
			+ "concat(adopet.adoPetNo, adopet.breeder, adopet.employee, adopet.adoStatus, adopet.petType, adopet.petName, adopet.petBreed, adopet.petSex, adopet.petBirth, adopet.petWeight, adopet.petCat, adopet.petChar, adopet.location)"
			+ "like %?1%")
	List<AdoPet> findAll(String word);

}
