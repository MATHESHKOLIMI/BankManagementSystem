package com.bank.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Transaction;
import com.bank.repository.TransactionRepository;
import com.bank.service.TransactionServiceInterface;

@Service
public class TransactionServiceImpl implements TransactionServiceInterface {

	@Autowired
	TransactionRepository repository;
	
	@Override
	public Transaction createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return repository.save(transaction);
	}

	@Override
	public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Transaction getTransactionById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<Transaction> getAllTransactionByAccountNumber(String accountNo) {
		// TODO Auto-generated method stub
		return repository.findByAccountNo(accountNo);
	}

}


















