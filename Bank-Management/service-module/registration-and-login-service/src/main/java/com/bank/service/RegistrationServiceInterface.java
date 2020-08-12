package com.bank.service;

import com.bank.model.Customer;

public interface RegistrationServiceInterface {
	public Customer createCustomer(Customer customer);
	public Customer findCustomerById(String customerId);
	public Customer findCustomerByPAN(String customerPAN);
	public Customer updateCustomer(String id, Customer customer);
}
