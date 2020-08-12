package com.bank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bank.model.Customer;

public interface RegistrationRepository extends MongoRepository<Customer, String> {
	public Customer findByCustomerPAN(String customerPAN);
}
