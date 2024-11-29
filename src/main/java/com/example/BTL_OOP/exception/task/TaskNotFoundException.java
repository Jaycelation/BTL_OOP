package com.example.BTL_OOP.exception.task;

import com.example.BTL_OOP.exception.base.NotFoundException;

public class TaskNotFoundException extends NotFoundException {
  public TaskNotFoundException() {
    super("com.example.demo_authen_jwt.exception.task.TaskNotFoundException");
  }
}
