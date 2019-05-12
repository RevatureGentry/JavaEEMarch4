package com.revature.web;

import com.revature.util.TokenRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author William Gentry
 */
@RestController
public class LogoutController {

    private final TokenRegistry tokenRegistry;

    public LogoutController(TokenRegistry tokenRegistry) {
        this.tokenRegistry = tokenRegistry;
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<?> logout(@RequestHeader("My-Auth-Token") String token) {
        if (tokenRegistry.revokeUserByToken(token))
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.badRequest().build();
    }
}
