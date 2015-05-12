package com.gnology.aop;

import org.springframework.stereotype.Component;

@Component("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {

	public Customer getCustomer(long customreId) {
		return null;
	}

	public String getCustomerName(long customerId) {
		return "Adam";
	}
	
	public void addCustomer(Customer customer){
		if(customer.getName() == null){
			throw new RuntimeException("Customer's name can't be null");
		}
		
		System.out.println("Customer " + customer.getName() +" saved");
	}



}
