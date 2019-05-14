package com.revature.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Map;

/**
 * @author William Gentry
 */
public class BadCredentialsException extends BaseApplicationException {

    public BadCredentialsException() {
        super("Invalid Credentials");
    }

    public HttpStatus getStatus() {
        return HttpStatus.FORBIDDEN;
    }

}
