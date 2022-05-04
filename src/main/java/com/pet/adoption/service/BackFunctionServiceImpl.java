package com.pet.adoption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.adoption.model.BackFunction;
import com.pet.adoption.repository.BackFunctionRepository;

@Service
public class BackFunctionServiceImpl implements BackFunctionService {

	@Autowired
	private BackFunctionRepository backFunctionRepository;
	@Override
	public List<BackFunction> getAllFunctions() {
		return backFunctionRepository.findAll();
	}
	
}
