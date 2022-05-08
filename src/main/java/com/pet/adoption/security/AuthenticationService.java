package com.pet.adoption.security;

import com.pet.adoption.dto.LoginTokenDto;
import com.pet.adoption.dto.param.LoginParam;
import com.pet.adoption.dto.param.RefreshTokenParam;

public interface AuthenticationService {
	
	LoginTokenDto loginAndReturnJWT(LoginParam empLoginReq);

	LoginTokenDto refreshToken(RefreshTokenParam refreshTokenParam);
}
