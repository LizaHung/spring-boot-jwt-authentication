package com.pet.adoption.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.adoption.model.BackFunction;
import com.pet.adoption.service.BackFunctionService;

@RestController
@RequestMapping("/function")
public class BackFunctionController {
	
	@Autowired
	private BackFunctionService backFunctionService;
	
	@GetMapping
	public List<BackFunction> getAllFunctions() {
		return backFunctionService.getAllFunctions();
	}
	
//	@GetMapping("")
//	public BackFunction getAllFunctions() {
//		return null;
//	}

}
