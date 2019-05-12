package com.revature.web;

import com.revature.exception.BaseApplicationException;
import com.revature.model.User;
import com.revature.model.dto.UserInfo;
import com.revature.service.TokenService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author William Gentry
 */
@RestController
public class UserInfoController {

    private final TokenService tokenService;

    public UserInfoController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping(value = "info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserInfo(@RequestHeader("My-Auth-Token") String token) {
        try {
            // Get a reference to the user that the token is associated with
            User user = tokenService.findUserByToken(token);
            return ResponseEntity.ok(new UserInfo(user));
        } catch (BaseApplicationException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getJSONMessage());
        }
    }
}
