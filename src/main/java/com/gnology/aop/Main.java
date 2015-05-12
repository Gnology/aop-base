package com.gnology.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		CustomerRepository customerRepository = context.getBean(
				"customerRepository", CustomerRepository.class);

		Customer customer1 = new Customer("Kamil");
		Customer customer3 = new Customer("Adam");
		
		customerRepository.addCustomer(customer1);
		customerRepository.addCustomer(customer3);
	
	}

}
