package com.gnology.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml");
		CustomerRepository customerRepository = context.getBean(
				"customerRepository", CustomerRepository.class);

		Customer customer1 = new Customer("Adam");
		Customer customer2 = new Customer(null);

		try {
			customerRepository.addCustomer(customer1);
			customerRepository.addCustomer(customer2);
		} catch (Exception e) {

		}
	}

}
