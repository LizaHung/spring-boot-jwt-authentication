package com.pet.adoption.service;

import java.util.List;

import com.pet.adoption.common.AdoStatusEnum;
import com.pet.adoption.dto.param.AdoPetParam;
import com.pet.adoption.dto.param.PdfParam;
import com.pet.adoption.model.AdoPet;
import com.pet.adoption.model.Member;

public interface AdoPetService {

	AdoPet updateAdoPet(AdoPetParam adoPet);
	
	AdoPet updateAdoStatus(Long adoPetNo, String adoStatus);

	List<AdoPet> findByAdoStatus(AdoStatusEnum adoStatus);
	
	void deleteAdopet(Long adoPetNo);

	List<AdoPet> findAllAdopet();

	AdoPet saveAdoPet(AdoPetParam adoPet);

	List<AdoPet> searchAdopet(String word);

	AdoPet findByAdoPetNo(Long adoPetNo);

	List<AdoPet> findByMember(Member member);
	
	void insertAppForm(PdfParam param);
	void updateAppForm(PdfParam param);
//	AdoPet updateAdoPet(Long adoptNo, Map<Object, Object> param);

}
