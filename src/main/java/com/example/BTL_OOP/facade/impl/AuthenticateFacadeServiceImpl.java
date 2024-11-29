package com.example.BTL_OOP.facade.impl;

import com.example.BTL_OOP.configuration.PropertiesConfiguration;
import com.example.BTL_OOP.dto.request.authenticate.CreateTokenRequest;
import com.example.BTL_OOP.dto.request.authenticate.LoginRequest;
import com.example.BTL_OOP.dto.request.authenticate.RefreshTokenRequest;
import com.example.BTL_OOP.dto.response.authenticate.LoginResponse;
import com.example.BTL_OOP.entity.User;
import com.example.BTL_OOP.enums.TokenType;
import com.example.BTL_OOP.exception.authenticate.PasswordIncorrectException;
import com.example.BTL_OOP.exception.authenticate.TokenInvalidException;
import com.example.BTL_OOP.facade.AuthenticateFacadeService;
import com.example.BTL_OOP.service.UserService;
import com.example.BTL_OOP.service.authenticate.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.example.BTL_OOP.utils.PasswordEncoderUtils.getPasswordEncoder;

@Service
@RequiredArgsConstructor
public class AuthenticateFacadeServiceImpl implements AuthenticateFacadeService {
  private final UserService userService;
  private final TokenService tokenService;
  private final PropertiesConfiguration propertiesConfiguration;

  @Override
  public LoginResponse login(LoginRequest request) {

    User user = userService.findByUserName(request.email());
    this.equalPassword(request.password(), user.getPassword());

    var tokenData = this.buildTokenData(user);

    final var accessToken = createToken(user.getId(), tokenData, TokenType.ACCESS_TOKEN);
    final var refreshToken = createToken(user.getId(), tokenData, TokenType.REFRESH_TOKEN);


    return new LoginResponse(
          user.getId(),
          accessToken,
          refreshToken,
          propertiesConfiguration.getAccessTokenTtl(),
          propertiesConfiguration.getRefreshTokenTtl()
    );
  }

  @Override
  public LoginResponse refreshToken(RefreshTokenRequest request) {
    final var refreshTokenRequest = request.refreshToken();

    if (Objects.isNull(refreshTokenRequest) || refreshTokenRequest.isBlank()) {

      throw new TokenInvalidException();
    }

    final var userId = tokenService.getTokenSubject(refreshTokenRequest, TokenType.REFRESH_TOKEN);
    final var user = userService.findById(userId);


    final var tokenData = buildTokenData(user);

    final var accessToken = createToken(user.getId(), tokenData, TokenType.ACCESS_TOKEN);
    final var refreshToken = createToken(user.getId(), tokenData, TokenType.REFRESH_TOKEN);

    return new LoginResponse(
          user.getId(),
          accessToken,
          refreshToken,
          propertiesConfiguration.getAccessTokenTtl(),
          propertiesConfiguration.getRefreshTokenTtl());
  }


  private void equalPassword(String passwordRaw, String passwordEncrypted) {
    if (!getPasswordEncoder().matches(passwordRaw, passwordEncrypted)) {
      throw new PasswordIncorrectException();
    }
  }

  private Map<String, String> buildTokenData(User user) {
    final var tokenData = new HashMap<String, String>();
    tokenData.put("email", user.getEmail());
    tokenData.put("name", user.getName());
    tokenData.put("user_id", String.valueOf(user.getId()));

    return tokenData;
  }

  private String createToken(String subject, Map<String, String> data, TokenType tokenType) {


    Long expired = null;
    if (Objects.equals(tokenType, TokenType.ACCESS_TOKEN)) {
      expired = propertiesConfiguration.getAccessTokenTtl();
    } else if (Objects.equals(tokenType, TokenType.REFRESH_TOKEN)) {
      expired = propertiesConfiguration.getRefreshTokenTtl();
    }

    final var createTokenRequest = new CreateTokenRequest(subject, tokenType, expired, data);

    return tokenService.createToken(createTokenRequest);
  }
}

