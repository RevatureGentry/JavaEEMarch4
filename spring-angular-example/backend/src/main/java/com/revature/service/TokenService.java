package com.revature.service;

import com.revature.model.User;

/**
 * @author William Gentry
 */
public interface TokenService {

    User findUserByToken(String token);
}
