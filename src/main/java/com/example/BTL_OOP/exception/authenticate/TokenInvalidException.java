package com.example.BTL_OOP.exception.authenticate;


import com.example.BTL_OOP.exception.base.UnauthorizedException;

public class TokenInvalidException extends UnauthorizedException {
  public TokenInvalidException() {
    super("com.example.demo_authen_jwt.exception.authenticate.TokenValidException");
  }
}
