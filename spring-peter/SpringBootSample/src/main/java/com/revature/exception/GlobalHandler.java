package com.revature.exception;

import static com.revature.util.ClientMessageUtil.INVALID_HERO_DATA;
import static com.revature.util.ClientMessageUtil.SOMETHING_WENT_WRONG;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.revature.ajax.ClientMessage;

@ControllerAdvice
public class GlobalHandler {
	private static Logger logger = Logger.getLogger(GlobalHandler.class);
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ClientMessage> handleAnyException(Throwable t) {
		logger.error("Internal Error", t);
		return new ResponseEntity<>(SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidHeroException.class)
	public ResponseEntity<ClientMessage> handleInvalidHeroException(InvalidHeroException i) {
		logger.error("Invalid hero data detected.", i);
		return new ResponseEntity<>(INVALID_HERO_DATA, HttpStatus.BAD_REQUEST);
	}
}
