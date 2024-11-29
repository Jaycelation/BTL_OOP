package com.example.BTL_OOP.exception.base;

import java.util.Map;

import static com.example.BTL_OOP.constant.AuthConstant.MessageException.BLANK_MESSAGE;
import static com.example.BTL_OOP.constant.AuthConstant.MessageException.DEFAULT_CODE_SERVER_ERROR;

public class InternalServerError extends BaseException {
  public InternalServerError(String code, String message, Map<String, String> params) {
    super(code, message, StatusConstants.SERVER_ERROR, params);
  }

  public InternalServerError() {
    super(DEFAULT_CODE_SERVER_ERROR, BLANK_MESSAGE, StatusConstants.SERVER_ERROR, null);
  }

  public InternalServerError(String message) {
    super(DEFAULT_CODE_SERVER_ERROR, message, StatusConstants.SERVER_ERROR, null);
  }
}
