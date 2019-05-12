package com.revature.exception;

import org.springframework.http.HttpStatus;

/**
 * @author William Gentry
 */
public class TokenNotPresentException extends BaseApplicationException {

    public TokenNotPresentException() {
        super("You must log in to continue");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.FORBIDDEN;
    }
}
