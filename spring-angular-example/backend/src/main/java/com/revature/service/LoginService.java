package com.revature.service;

import com.revature.model.User;
import com.revature.model.dto.LoginForm;

/**
 * @author William Gentry
 */
public interface LoginService {

    String attemptLogin(LoginForm loginForm);
}
