package com.example.BTL_OOP.controller;

import com.example.BTL_OOP.dto.response.ResponseGeneral;
import com.example.BTL_OOP.dto.response.UserResponse;
import com.example.BTL_OOP.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.BTL_OOP.constant.AuthConstant.MessageException.SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
  private final UserService userService;

  @GetMapping("{id}")
  public ResponseGeneral<UserResponse> getUser(
        @PathVariable String id
  ) {

    return ResponseGeneral.ofSuccess(
          SUCCESS,
          userService.detail(id)
    );
  }

  @GetMapping
  public ResponseGeneral<List<UserResponse>> getAllUsers(
  ) {
    return ResponseGeneral.ofSuccess(
          SUCCESS,
          userService.findAll()
    );
  }

}
