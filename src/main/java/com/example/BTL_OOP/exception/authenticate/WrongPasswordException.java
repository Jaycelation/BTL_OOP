package com.example.BTL_OOP.exception.authenticate;


import com.example.BTL_OOP.exception.base.BadRequestException;

public class WrongPasswordException extends BadRequestException {
  public WrongPasswordException(){
    super("com.example.demo_authen_jwt.exception.authenticate.WrongPasswordException");
  }
}
