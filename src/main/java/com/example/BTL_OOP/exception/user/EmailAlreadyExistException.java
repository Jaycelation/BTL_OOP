package com.example.BTL_OOP.exception.user;

import com.example.BTL_OOP.exception.base.ConflictException;

public class EmailAlreadyExistException extends ConflictException {
  public EmailAlreadyExistException() {
    super("com.example.demo_authen_jwt.exception.user.EmailAlreadyExistException");
  }
}
