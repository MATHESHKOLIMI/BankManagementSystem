package com.bank.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	@Id
	@NotNull
	@Pattern(regexp = "[1-9] {1}[0-9] {12}")
	String transactionId;
	String accountNo;
	String toAccount;
	Status statusOfTransaction;
	double amount;
	String transactionDetails;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@NotNull
	Date dateOfTransaction;
}
