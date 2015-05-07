package com.gnology.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class InfoAspect{
	Logger logger = Logger.getLogger(getClass().getName());
	
	public void getInfo(JoinPoint joinPoint){
		Customer customer = (Customer) joinPoint.getArgs()[0];
		if(customer.getName().length() >= 2){
			logger.info("Name: " + customer.getName() + " is too short");
		}
		else{
			logger.info("Name: " + customer.getName() + " is good");
		}
	}
	
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
