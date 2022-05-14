package com.pet.adoption.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.pet.adoption.model.AdoPetPic;
import com.pet.adoption.repository.AdoPetPicRepository;
import com.pet.adoption.util.PhotoReader;

/**
 * 
 *
 * @author <a href="mailto:lizahung1008@gmail.com"> Liza Hung</a>
 */
@Service
public class AdoPetPicServiceImpl implements AdoPetPicService {

	@Autowired
	private AdoPetPicRepository adoPetPicRepository;

	@Autowired
	private PhotoReader photoReader;

	@Value("${pic.pet.path}")
	private String defaultPhoto;

	@Autowired
	private ResourceLoader resourceLoader;

	@Override
	public void deletePic(Long adoPicNo) {
		adoPetPicRepository.deleteById(adoPicNo);
	}

	@Override
	public void getAdopetPhoto(HttpServletResponse res, Long adopetNo, Long adoPicNo) throws IOException {
		AdoPetPic pics = adoPetPicRepository.findByAdoPetNoAndAdoPicNo(adopetNo, adoPicNo);

		byte[] photo;
		if (pics != null)
			photo = pics.getAdoPetPic();
		else
			photo = resourceLoader.getResource(defaultPhoto).getInputStream().readAllBytes();

		photoReader.readPhoto(res, photo);
	}

	@Override
	public void getRandomPhoto(HttpServletResponse res, Long adoPetNo) throws IOException {
		List<AdoPetPic> pics = adoPetPicRepository.findByAdoPetNo(adoPetNo);

		byte[] photo;
		if (pics.size() == 0)
			photo = resourceLoader.getResource(defaultPhoto).getInputStream().readAllBytes();
		else
			photo = adoPetPicRepository.findByAdoPetNo(adoPetNo).get(0).getAdoPetPic();

		photoReader.readPhoto(res, photo);

	}

}
