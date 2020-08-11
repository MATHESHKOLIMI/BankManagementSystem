package com.bank.service;

import java.util.List;

import com.bank.model.Transaction;

public interface TransactionServiceInterface {
	public Transaction createTransaction(Transaction transaction);
	public List<Transaction> getAllTransactions();
	public Transaction getTransactionById(String id);
	public List<Transaction> getAllTransactionByAccountNumber(String accountNo);
}
