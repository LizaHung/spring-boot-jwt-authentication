package com.pet.adoption.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.adoption.dto.param.PdfParam;
import com.pet.adoption.model.AdoPet;
import com.pet.adoption.service.AdoPetService;

/**
 * 
 *
 * @author <a href="mailto:lizahung1008@gmail.com"> Liza Hung</a>
 */

@RestController
@RequestMapping("/adoption/pdf")
public class PdfController {

	@Autowired
	private AdoPetService adoPetService;

	@PostMapping
	public void addPdf(PdfParam param) {
		adoPetService.insertAppForm(param);
	}
	
	@GetMapping("/{adoPetNo}")
	public void readPdf(HttpServletResponse res, @PathVariable Long adoPetNo) throws IOException {
		res.setHeader("Content-Disposition","inline; filename=\"Petfect Match Application.pdf\"");
		res.setContentType("application/pdf; name=\"Petfect Match Application.pdf\"");
		
		AdoPet adopet = adoPetService.findByAdoPetNo(adoPetNo);
		ServletOutputStream out = res.getOutputStream();

		byte[] buf = new byte[4 * 1024];

		ByteArrayInputStream bin = new ByteArrayInputStream(adopet.getAppForm());

		int len;
		while ((len = bin.read(buf)) != -1) {
			out.write(buf, 0, len);
			
		}
		bin.close();
		out.close();
		
	}
	
	@PutMapping
	public void confirmApplication(PdfParam param) {
		adoPetService.updateAppForm(param);
	}

}
