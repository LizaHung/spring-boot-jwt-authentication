package com.pet.adoption.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pet.adoption.common.AdoStatusEnum;
import com.pet.adoption.dto.AdoPetDto;
import com.pet.adoption.dto.param.AdoPetParam;
import com.pet.adoption.model.AdoPet;
import com.pet.adoption.model.AdoPetPic;
import com.pet.adoption.service.AdoPetPicService;
import com.pet.adoption.service.AdoPetService;
import com.pet.adoption.util.ModelMapperUtil;

@RestController
@RequestMapping("/adoption")
public class AdoPetController {

	@Autowired
	private AdoPetService adoPetService;
	@Autowired
	private AdoPetPicService adoPetPicService;

	@Autowired
	private ModelMapperUtil modelMapperUtil;

	@PostMapping("/adopets")
	public AdoPetDto addAdoPet(@Valid AdoPetParam adoPetParam) {
		return modelMapperUtil.map(adoPetService.saveAdoPet(adoPetParam), AdoPetDto.class);
	}

	@PutMapping("/adopets")
	public AdoPetDto updateAdoPet(@Valid AdoPetParam adoPet) {
		return modelMapperUtil.map(adoPetService.updateAdoPet(adoPet), AdoPetDto.class);
	}
	
	@PatchMapping("/adopets/{adoPetNo}")
	public AdoPetDto updateAdoStatus(@PathVariable Long adoPetNo, @RequestParam String adoStatus) {
		return modelMapperUtil.map(adoPetService.updateAdoStatus(adoPetNo, adoStatus), AdoPetDto.class);
	}


	@DeleteMapping("/adopets/{adoPetNo}")
	public void deleteAdopet(@PathVariable Long adoPetNo) {
		adoPetService.deleteAdopet(adoPetNo);
	}

	@GetMapping("/adopets")
	public List<AdoPetDto> getAllAdoPet() {
		return modelMapperUtil.mapList(adoPetService.findAllAdopet(), AdoPetDto.class);
	}

	@GetMapping("/adopets/{adostatus}")
	public List<AdoPetDto> getAllByAdoStatus(@PathVariable AdoStatusEnum adostatus) {
		return modelMapperUtil.mapList(adoPetService.findByAdoStatus(adostatus), AdoPetDto.class);
	}

	@GetMapping("/{word}")
	public List<AdoPetDto> searchAdopet(@PathVariable String word) {
		List<AdoPet> adoPets = adoPetService.searchAdopet(word);
		return modelMapperUtil.mapList(adoPets, AdoPetDto.class);
	}

	@GetMapping("/getOne/{adoPetNo}")
	public AdoPetDto findByAdoPetNo(@PathVariable Long adoPetNo) {
		return modelMapperUtil.map(adoPetService.findByAdoPetNo(adoPetNo), AdoPetDto.class);
	}

	@DeleteMapping("/adopics/{adoPicNo}")
	public void deletePics(@PathVariable Long adoPicNo) {
		adoPetPicService.deletePic(adoPicNo);
	}

	@GetMapping("/show")
	public void getAdopetPhoto(HttpServletResponse res, @RequestParam("adopetNo") Long adopetNo,
			@RequestParam("adoPicNo") Long adoPicNo) throws IOException {

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();

		AdoPetPic pics = adoPetPicService.getAdopetPhoto(adopetNo, adoPicNo);

		byte[] buf = new byte[4 * 1024];

		if (pics.getAdoPetPic() != null) {
			ByteArrayInputStream bin = new ByteArrayInputStream(pics.getAdoPetPic());

			int len;
			while ((len = bin.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			bin.close();
			out.close();
		}

	}

	@GetMapping("/show/{adopetNo}")
	public void getAdopetPhoto(HttpServletResponse res, @PathVariable("adopetNo") Long adopetNo) throws IOException {

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();

		AdoPetPic pic = adoPetPicService.getRandomPhoto(adopetNo);

		if (pic.getAdoPetPic() != null) {
		byte[] buf = new byte[4 * 1024];

			ByteArrayInputStream bin = new ByteArrayInputStream(pic.getAdoPetPic());

			int len;
			while ((len = bin.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			bin.close();
			out.close();
		}

	}

}
