package com.pet.adoption.security;

import com.pet.adoption.dto.LoginTokenDto;
import com.pet.adoption.dto.param.LoginParam;

public interface AuthenticationService {
	
	LoginTokenDto loginAndReturnJWT(LoginParam empLoginReq);
}
