package com.example.market.service;

import com.example.market.entity.Token;

public interface TokenService {

    Token createToken(Token token);

    Token findByToken(String token);
}
