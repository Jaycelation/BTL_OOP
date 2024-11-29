package com.example.BTL_OOP.exception.authenticate;


import com.example.BTL_OOP.exception.base.BadRequestException;

public class PasswordNotNullException extends BadRequestException {
  public PasswordNotNullException(){
    super("com.example.demo_authen_jwt.exception.authenticate.PasswordNotNullException");
  }
}
