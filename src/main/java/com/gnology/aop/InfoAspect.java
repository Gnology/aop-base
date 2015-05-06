package com.gnology.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class InfoAspect{
	Logger logger = Logger.getLogger(getClass().getName());
	
	public void getInfo(JoinPoint joinPoint){
		logger.info(joinPoint.getSignature().getName() + " has been excuted");
	}
}
