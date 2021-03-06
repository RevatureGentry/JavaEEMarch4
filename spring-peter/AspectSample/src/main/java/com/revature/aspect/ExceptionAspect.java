package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAspect {
	private static final Logger logger = Logger.getLogger(ExceptionAspect.class);
	
	@AfterThrowing(pointcut="execution(* * (..))", throwing="e")
	public void exceptionHandling(JoinPoint jp, Exception e) {
		logger.error("Exception thrown in: " + jp.getStaticPart().getSignature().toString(), e);
	}
}
