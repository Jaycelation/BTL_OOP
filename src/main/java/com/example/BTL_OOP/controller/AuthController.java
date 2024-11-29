package com.example.BTL_OOP.controller;

import com.example.BTL_OOP.dto.request.user.UserRequest;
import com.example.BTL_OOP.dto.request.authenticate.LoginRequest;
import com.example.BTL_OOP.dto.request.authenticate.RefreshTokenRequest;
import com.example.BTL_OOP.dto.response.ResponseGeneral;
import com.example.BTL_OOP.dto.response.UserResponse;
import com.example.BTL_OOP.dto.response.authenticate.LoginResponse;
import com.example.BTL_OOP.facade.AuthenticateFacadeService;
import com.example.BTL_OOP.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.BTL_OOP.constant.AuthConstant.MessageException.SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
@CrossOrigin("*")
public class AuthController {
  private final AuthenticateFacadeService authenticateFacadeService;
  private final UserService userService;

  @PostMapping("/login")
  public ResponseGeneral<LoginResponse> login(
        @RequestBody LoginRequest request
  ) {

    return ResponseGeneral.ofSuccess(
          SUCCESS,
          authenticateFacadeService.login(request));
  }

  @PostMapping("/refresh")
  public ResponseGeneral<LoginResponse> refresh(
        @RequestBody RefreshTokenRequest request
  ) {

    return ResponseGeneral.ofSuccess(
          SUCCESS,
          authenticateFacadeService.refreshToken(request));
  }


  @PostMapping("/register")
  public ResponseGeneral<UserResponse> register(
        @RequestBody UserRequest request
  ) {

    return ResponseGeneral.ofCreated(
          SUCCESS,
          userService.create(request)
    );
  }

}
