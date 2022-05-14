package com.pet.adoption.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.pet.adoption.model.AdoPetPic;

/**
 * 
 *
 * @author <a href="mailto:lizahung1008@gmail.com"> Liza Hung</a>
 */

public interface AdoPetPicService {

	void deletePic(Long adoPicNo);
	void getRandomPhoto (HttpServletResponse res, Long adoPetNo) throws IOException;
	void getAdopetPhoto (HttpServletResponse res, Long adopetNo, Long adoPicNo) throws IOException;
}
