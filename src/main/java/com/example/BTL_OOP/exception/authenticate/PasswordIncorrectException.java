package com.example.BTL_OOP.exception.authenticate;


import com.example.BTL_OOP.exception.base.BadRequestException;

public class PasswordIncorrectException extends BadRequestException {
  private static final String DEFAULT_CODE = "com.example.demo_authen_jwt.exception.authenticate.PasswordIncorrectException";

  public PasswordIncorrectException() {
    super(DEFAULT_CODE);
  }
}
