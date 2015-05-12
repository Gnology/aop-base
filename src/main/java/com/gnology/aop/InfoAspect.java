package com.gnology.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InfoAspect{
	Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* *(..))")
	public void allMethods(){};
	
	@Before("allMethods()")
	public void getInfo(JoinPoint joinPoint){
		Customer customer = (Customer) joinPoint.getArgs()[0];
		if(customer.getName().length() >= 2){
			logger.info("Name: " + customer.getName() + " is too short");
		}
		else{
			logger.info("Name: " + customer.getName() + " is good");
		}
	}
	
	@Around("allMethods()")
	public void changeName(ProceedingJoinPoint proceedingJoinPoint){
		Customer customer = (Customer) proceedingJoinPoint.getArgs()[0];
			try {
				if(!customer.getName().equals("Adam")){
					Object[] args = new Object[] {new Customer("Anonym")};
					proceedingJoinPoint.proceed(args);
				}
				
				else{
					proceedingJoinPoint.proceed();
				} 
			}
				catch (Throwable e) {
				}
	}
}
