package com.revature.web;

import com.revature.exception.BaseApplicationException;
import com.revature.model.User;
import com.revature.model.dto.RegistrationForm;
import com.revature.service.RegistrationService;
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
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> attemptRegistration(@RequestBody RegistrationForm registrationForm) {
        try {
            final User user = registrationService.attemptRegistration(registrationForm);

            // If registration is successful, return a 200 status code with a Response Body telling the user the operation was successful
            return ResponseEntity.ok(Collections.singletonMap("message", user.getUsername() + " registered successfully!"));
        } catch (BaseApplicationException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getJSONMessage());
        }
    }
}
