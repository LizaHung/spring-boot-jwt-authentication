/**
 * 
 */
package com.pet.adoption.service;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.adoption.dto.param.EmpAuthorityParam;
import com.pet.adoption.model.EmpAuthority;
import com.pet.adoption.repository.EmpAuthorityRepository;

/**
 * @author <a href="mailto:lizahung1008@gmail.com"> Liza Hung</a>
 *
 */
@Service
public class EmpAuthorityServiceImpl implements EmpAuthorityService {

	@Autowired
	private EmpAuthorityRepository empAuthorityRepository;

	@Override
	public List<EmpAuthority> saveFunByRole(Long empno, String role) {
		List<EmpAuthority> authorities = new ArrayList<>();
		Integer[] adminFun = { 1, 2, 3, 4, 5 };
		Integer[] staffFun = { 3, 4 };
		if (role.equals("ROLE_ADMIN"))
			authorities = getAuthList(Arrays.asList(adminFun), empno);
		else
			authorities = getAuthList(Arrays.asList(staffFun), empno);

		return empAuthorityRepository.saveAll(authorities);
	}

	@Override
	public List<EmpAuthority> findByEmpNo(Long empNo) {
		return empAuthorityRepository.findByEmpNo(empNo);
	}

	@Override
	public List<EmpAuthority> saveAuthority(EmpAuthorityParam param) {
		List<EmpAuthority> authorities = getAuthList(param.getFunNo(), param.getEmpNo());
		List<EmpAuthority> existAuthorities = empAuthorityRepository.findByEmpNo(param.getEmpNo());
		List<EmpAuthority> delAuthorities = existAuthorities.stream().filter(item -> !authorities.contains(item))
				.collect(Collectors.toList());
		empAuthorityRepository.deleteAll(delAuthorities);
		return empAuthorityRepository.saveAll(authorities);
	}

	public List<EmpAuthority> getAuthList(List<Integer> data, Long emono) {
		return data.stream().map((item) -> new EmpAuthority(emono, Long.valueOf(item))).collect(Collectors.toList());
	}

}
