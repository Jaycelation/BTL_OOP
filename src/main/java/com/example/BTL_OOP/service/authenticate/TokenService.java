package com.example.BTL_OOP.service.authenticate;


import com.example.BTL_OOP.dto.request.authenticate.CreateTokenRequest;
import com.example.BTL_OOP.enums.TokenType;
import io.jsonwebtoken.Claims;

public interface TokenService {
  String createToken(CreateTokenRequest request);

  String getTokenSubject(String token, TokenType tokenType);

  Boolean validateToken(String token, String usernameLogin, TokenType tokenType);

  Claims extractAllClaims(String token, TokenType tokenType);
}
