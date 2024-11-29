package com.example.BTL_OOP.exception.authenticate;


import com.example.BTL_OOP.exception.base.BadRequestException;

public class UsernameNotNullException extends BadRequestException {
  public UsernameNotNullException() {
    super("com.example.demo_authen_jwt.exception.authenticate.UsernameNotNullException");
  }
}
