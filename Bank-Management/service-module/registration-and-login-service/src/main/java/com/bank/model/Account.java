package com.bank.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	@Id
	@NotNull
	@Pattern(regexp = "[1-9][0-9] {9}")
	String accountNo;
	AccountType account;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE_TIME)
	Date dateOfOpening;
	@NotNull
	@Pattern(regexp = "[A-Z] {4}[0-9] {7}")
	String branchIFSC;
	List<Transaction> transaction;
}
