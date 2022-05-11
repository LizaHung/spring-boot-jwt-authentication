package com.pet.adoption.service;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import com.pet.adoption.common.AdoStatusEnum;
import com.pet.adoption.dto.param.AdoPetParam;
import com.pet.adoption.dto.param.PdfParam;
import com.pet.adoption.model.AdoPet;

public interface AdoPetService {

	AdoPet updateAdoPet(AdoPetParam adoPet);
	
	AdoPet updateAdoStatus(Long adoPetNo, String adoStatus);

	List<AdoPet> findByAdoStatus(AdoStatusEnum adoStatus);
	
	void deleteAdopet(Long adoPetNo);

	List<AdoPet> findAllAdopet();

	AdoPet saveAdoPet(AdoPetParam adoPet);

	List<AdoPet> searchAdopet(String word);

	AdoPet findByAdoPetNo(Long adoPetNo);

	void insertAppForm(PdfParam param) throws IOException;
	void updateAppForm(PdfParam param) throws IOException, MessagingException;

}
