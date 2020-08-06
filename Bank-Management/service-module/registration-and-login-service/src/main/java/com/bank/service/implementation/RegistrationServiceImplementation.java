package com.bank.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Customer;
import com.bank.repository.RegistrationRepository;
import com.bank.service.RegistrationServiceInterface;

@Service
@Transactional
public class RegistrationServiceImplementation implements RegistrationServiceInterface {

	@Autowired
	RegistrationRepository repository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer demoCustomer=repository.findByCustomerPAN(customer.getCustomerPAN());
		if(demoCustomer!=null) {
		return null;
		}else {
			return repository.save(customer);
		}
	}

	@Override
	public Customer findCustomerById(String customerId) {
		// TODO Auto-generated method stub
		return repository.findById(customerId).get();
	}

	@Override
	public Customer findCustomerByPAN(String customerPAN) {
		// TODO Auto-generated method stub
		return repository.findByCustomerPAN(customerPAN);
	}

}
