package com.revature.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BenchmarkAspect {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Around("@annotation(com.revature.annotations.Benchmark)")
	public Object benchmarkAllMethodsWithAnnotation(ProceedingJoinPoint jp) throws Throwable {
		logger.info("About to begin benchmarking {}", jp.getSignature());
		long start = System.currentTimeMillis();
		
		// In order to actually execute this method, we call proceed()
		Object result = jp.proceed();
		
		long finish = System.currentTimeMillis();
		logger.info("Method execution complete. Calculating time to complete...");
		logger.info("{} took {} ms to complete", jp.getSignature().toShortString(), (finish - start));
		return result;
	}
	
}
