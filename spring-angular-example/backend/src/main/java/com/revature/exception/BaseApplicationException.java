package com.revature.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Map;

/**
 * @author William Gentry
 */
public abstract class BaseApplicationException extends RuntimeException {

    public BaseApplicationException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatus();

    public Map<String, String> getJSONMessage() {
        return Collections.singletonMap("message", getMessage());
    }
}
