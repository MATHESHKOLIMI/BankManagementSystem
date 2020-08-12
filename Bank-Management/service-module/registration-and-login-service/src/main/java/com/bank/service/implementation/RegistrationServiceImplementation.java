package com.bank.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Customer;
import com.bank.model.Transaction;
import com.bank.repository.RegistrationRepository;
import com.bank.repository.TransactionRepository;
import com.bank.service.RegistrationServiceInterface;
import com.bank.service.TransactionServiceInterface;

@Service
@Transactional
public class RegistrationServiceImplementation implements RegistrationServiceInterface {

	@Autowired
	RegistrationRepository repository;
	
	@Autowired
	TransactionRepository trans;
	
	@Autowired
	TransactionServiceInterface transactionService;
	
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
		Customer customer=repository.findById(customerId).get();
		List<Transaction> listOfTransaction=transactionService.getAllTransactions();
		customer.getAccounts().forEach(p->{
			List<Transaction> transaction=p.getTransaction();
			transaction.addAll(listOfTransaction);
			p.setTransaction(transaction);
			});
		trans.deleteAll();
		repository.save(customer);
		return customer;
	}

	@Override
	public Customer findCustomerByPAN(String customerPAN) {
		// TODO Auto-generated method stub
		return repository.findByCustomerPAN(customerPAN);
	}

	@Override
	public Customer updateCustomer(String id, Customer customer) {
		// TODO Auto-generated method stub
		Customer cus=repository.findById(id).get();
		if(cus==null) {
			return null;
		}
		else {
			cus.setCustomerName(customer.getCustomerName());
			cus.setCustomerMail(customer.getCustomerMail());
			cus.setAddress(customer.getAddress());
			cus.setPassword(customer.getPassword());
		return repository.save(cus);
		}
	}

}
