package com.revature.service;

import com.revature.model.User;
import com.revature.util.TokenRegistry;
import org.springframework.stereotype.Service;

/**
 * @author William Gentry
 */
@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRegistry tokenRegistry;

    public TokenServiceImpl(TokenRegistry tokenRegistry) {
        this.tokenRegistry = tokenRegistry;
    }

    @Override
    public User findUserByToken(String token) {
        return tokenRegistry.findUserByToken(token);
    }
}
