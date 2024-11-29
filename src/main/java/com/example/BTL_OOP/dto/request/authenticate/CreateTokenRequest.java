package com.example.BTL_OOP.dto.request.authenticate;



import com.example.BTL_OOP.enums.TokenType;

import java.util.Map;

public record CreateTokenRequest (String subject, TokenType tokenType, long expiredSeconds, Map<String, String> data) {
}
