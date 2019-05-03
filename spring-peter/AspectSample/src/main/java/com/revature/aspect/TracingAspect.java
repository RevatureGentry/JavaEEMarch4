package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {
	private static final Logger logger = Logger.getLogger(TracingAspect.class);
	
	@Before("execution(* print* (..))")
	public void entering(JoinPoint jp) {
		logger.trace("Entering: " + jp.getStaticPart().getSignature().toString()
				+ " with parameter: " + jp.getArgs()[0]);
	}
	
	@After("execution(* print* (..))")
	public void exiting(JoinPoint jp) {
		logger.trace("Exiting: " + jp.getStaticPart().getSignature().toString()
				+ " with parameter: " + jp.getArgs()[0]);
	}
	
	@Around("execution(* print* (String))")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		logger.trace("Around: " + pjp.getStaticPart().getSignature().toString()
				+ " with parameter: " + pjp.getArgs()[0]);
	
		try {
			logger.info("String is a number: " + Integer.parseInt(pjp.getArgs()[0].toString()));
			pjp.proceed();
		} catch (NumberFormatException e) {
			logger.warn("String is not a number: " + pjp.getArgs()[0]);
		}
	}
	
	/*
	 * Never do this. Unless, it makes sense.
	 */
//	@Around("execution(* return* (..))")
//	public int aroundReturn(ProceedingJoinPoint pjp) {
//		return 0;
//	}
	
	@Before("execution(* return* (..))")
	public int aroundReturn(JoinPoint jp) {
		return 0;
	}
}
