package com.gnology.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class BenchmarkAspect {
	Logger logger = Logger.getLogger(getClass());

	public void measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint){
		long startTime = System.nanoTime();
		
		// method execution

		try {
			Customer customer = (Customer) proceedingJoinPoint.getArgs()[0];
			if (customer.getName() == null){
				Object[] args = new Object[] {new Customer("Anonym")};
				proceedingJoinPoint.proceed(args);
			}
			else{
				proceedingJoinPoint.proceed();
			}
			
		} catch (Throwable e) {
		
		}
		
		long endTime = System.nanoTime();
		logger.info("Execution time = " + (endTime-startTime) + "ns");
	}
}
