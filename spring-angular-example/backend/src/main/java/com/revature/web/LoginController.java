package com.revature.web;

import com.revature.exception.BadCredentialsException;
import com.revature.model.dto.LoginForm;
import com.revature.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @author William Gentry
 */
@RestController
public class LoginController {

    private final LoginService loginService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> attemptLogin(@RequestBody LoginForm loginForm) {
        try {
            final String token = loginService.attemptLogin(loginForm);

            // Return a JSON Response to the front end with a 200 status code, where the Response Body is the Auth Token
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        } catch (BadCredentialsException e) {
            logger.info("Login attempt failed: {} provided invalid credentials", loginForm.getUsername());

            // Return a Response to the front end with a 401 status code, and message
            // Both are defined in the com.revature.exception.BadCredentialsException class
            return ResponseEntity.status(e.getStatus()).body(e.getJSONMessage());
        }
    }
}
