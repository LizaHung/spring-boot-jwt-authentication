/**
 * 
 */
package com.pet.adoption.service;

import java.util.List;

import com.pet.adoption.dto.param.EmpAuthorityParam;
import com.pet.adoption.model.EmpAuthority;

/**
 * @author <a href="mailto:lizahung1008@gmail.com"> Liza Hung</a>
 *
 */
public interface EmpAuthorityService {

	List<EmpAuthority> saveFunByRole(Long empno, String role);

	List<EmpAuthority> findByEmpNo(Long empNo);
	List<EmpAuthority> saveAuthority(EmpAuthorityParam param);
}
