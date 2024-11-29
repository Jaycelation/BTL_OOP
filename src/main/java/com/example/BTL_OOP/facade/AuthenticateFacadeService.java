package com.example.BTL_OOP.facade;

import com.example.BTL_OOP.dto.request.authenticate.LoginRequest;
import com.example.BTL_OOP.dto.request.authenticate.RefreshTokenRequest;
import com.example.BTL_OOP.dto.response.authenticate.LoginResponse;

public interface AuthenticateFacadeService {
  LoginResponse login(LoginRequest request);

  LoginResponse refreshToken(RefreshTokenRequest request);
}
