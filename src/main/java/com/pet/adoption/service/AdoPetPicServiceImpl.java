package com.pet.adoption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.adoption.model.AdoPetPic;
import com.pet.adoption.repository.AdoPetPicRepository;

/**
 * 
 *
 * @author <a href="mailto:lizahung1008@gmail.com"> Liza Hung</a>
 */
@Service
public class AdoPetPicServiceImpl implements AdoPetPicService {

	@Autowired
	private AdoPetPicRepository adoPetPicRepository;

	@Override
	public void deletePic(Long adoPicNo) {
		adoPetPicRepository.deleteById(adoPicNo);;
	}

	@Override
	public AdoPetPic getAdopetPhoto(Long adopetNo, Long adoPicNo) {
		return adoPetPicRepository.findByAdoPetNoAndAdoPicNo(adopetNo, adoPicNo);
	}

	@Override
	public AdoPetPic getRandomPhoto(Long adoPetNo) {
		List <AdoPetPic> pics = adoPetPicRepository.findByAdoPetNo(adoPetNo);
		if(pics.size() == 0) return null;
		return adoPetPicRepository.findByAdoPetNo(adoPetNo).get(0);
	}

	
}
