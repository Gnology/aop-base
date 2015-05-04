package com.gnology.aop;

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
		
		System.out.println("Customer saved");
	}



}
