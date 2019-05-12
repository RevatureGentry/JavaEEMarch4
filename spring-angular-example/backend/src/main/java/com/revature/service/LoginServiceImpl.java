package com.revature.service;

import com.revature.exception.BadCredentialsException;
import com.revature.model.User;
import com.revature.model.dto.LoginForm;
import com.revature.repository.UserRepository;
import com.revature.util.TokenRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author William Gentry
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenRegistry tokenRegistry;

    public LoginServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenRegistry tokenRegistry) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRegistry = tokenRegistry;
    }

    @Override
    public String attemptLogin(LoginForm loginForm) {
        User user = userRepository.findUserByUsername(loginForm.getUsername());

        // Make sure the user exists by username
        if (user == null)
            throw new BadCredentialsException();

        // Check that the supplied password from the LoginForm matches what we have stored
        if (!passwordEncoder.matches(loginForm.getPassword(), user.getPassword()))
            throw new BadCredentialsException();

        return tokenRegistry.registerUserByToken(user);
    }
}
