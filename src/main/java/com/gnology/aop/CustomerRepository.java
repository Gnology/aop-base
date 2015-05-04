package com.gnology.aop;

public interface CustomerRepository {
	Customer getCustomer(long customreId);
	String getCustomerName(long customerId);
	void addCustomer(Customer customer);
}
