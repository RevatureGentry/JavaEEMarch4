package com.revature.util;

import com.revature.exception.TokenNotPresentException;
import com.revature.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author William Gentry
 */
@Service
public class TokenRegistry {

    private final Map<String, User> USER_REGISTRY = new HashMap<>();

    public User findUserByToken(String token) {
        return USER_REGISTRY.get(token);
    }

    public boolean revokeUserByToken(String token) {
        return USER_REGISTRY.remove(token) != null;
    }

    public String registerUserByToken(User user) {
        if (user == null)
            throw new TokenNotPresentException();
        final String token = UUID.randomUUID().toString() + UUID.randomUUID().toString();
        USER_REGISTRY.put(token, user);
        return token;
    }
}
