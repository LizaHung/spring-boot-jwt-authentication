/**
 * 
 */
package com.pet.adoption.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.adoption.dto.param.EmpAuthorityParam;
import com.pet.adoption.model.EmpAuthority;
import com.pet.adoption.service.EmpAuthorityService;


/**
 * @author <a href="mailto:lizahung1008@gmail.com"> Liza Hung</a>
 *
 */

@RestController
@RequestMapping("/authorities")
public class EmpAuthorityController {
	
	@Autowired
	private EmpAuthorityService empAuthorityService;
	
	
	@GetMapping("/{empNo}")
	public List<EmpAuthority> findByEmpNo(@PathVariable Long empNo) {
		return empAuthorityService.findByEmpNo(empNo);
	}
	
	@PutMapping
	public List<EmpAuthority> updateAuthority( @RequestBody EmpAuthorityParam param) {
			
		return empAuthorityService.saveAuthority(param);
	}


}
