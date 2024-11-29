package com.example.BTL_OOP.exception.comment;

import com.example.BTL_OOP.exception.base.NotFoundException;

public class CommentNotFoundException extends NotFoundException {
  public CommentNotFoundException() {
    super("com.example.demo_authen_jwt.exception.comment.CommentNotFoundException");
  }
}
