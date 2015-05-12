package com.gnology.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.gnology.aop")
@EnableAspectJAutoProxy
public class AppConfiguration {

}
