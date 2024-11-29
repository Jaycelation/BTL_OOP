package com.example.BTL_OOP.service;

import com.example.BTL_OOP.dto.request.user.UserRequest;
import com.example.BTL_OOP.dto.response.UserResponse;
import com.example.BTL_OOP.entity.User;

import java.util.List;

public interface UserService {
  UserResponse create(UserRequest request);

  UserResponse detail(String id);

  List<UserResponse> findAll();

  User findByUserName(String username);

  User findById(String id);


}
