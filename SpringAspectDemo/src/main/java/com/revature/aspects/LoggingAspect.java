package com.revature.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Before("within(com.revature.beans..*)")
	public void logEntranceIntoMethod(JoinPoint joinPoint) {
		logger.info("Beginning execution for {}", joinPoint.getSignature());
	}
}
