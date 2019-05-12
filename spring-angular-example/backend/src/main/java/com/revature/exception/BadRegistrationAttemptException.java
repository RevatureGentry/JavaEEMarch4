package com.revature.exception;

import org.springframework.http.HttpStatus;

/**
 * @author William Gentry
 */
public class BadRegistrationAttemptException extends BaseApplicationException {

    public BadRegistrationAttemptException(String registrationField) {
        super(registrationField + " field may not be empty");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
