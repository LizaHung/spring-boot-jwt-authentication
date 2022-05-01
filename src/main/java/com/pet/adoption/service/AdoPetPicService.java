package com.pet.adoption.service;

import java.util.List;

import com.pet.adoption.model.AdoPetPic;

/**
 * 
 *
 * @author <a href="mailto:lizahung1008@gmail.com"> Liza Hung</a>
 */

public interface AdoPetPicService {

	void deletePic(Long adoPicNo);
	AdoPetPic getRandomPhoto (Long adoPetNo);
	AdoPetPic getAdopetPhoto (Long adopetNo, Long adoPicNo);
}
