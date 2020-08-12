package com.bank.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class Customer {

	@Id
	@Min(value = 10)
	@NotNull
	private String customerId;
	@Max(value = 40)
	@NotNull
	private String customerName;
	@Pattern(regexp = "[A-Z] {5}[0-9] {4}[A-z]")
	@NotNull
	private String customerPAN;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE,pattern = "MM-DD-YYYY")
	private Date dateOfBirth;
	@Email
	private String customerMail;
	@Size(min = 10, max = 13)
	private String mobileNumber;
	List<Account> accounts;
	@NotNull
	@Min(value = 8)
	@Max(value = 16)
	private String password;
	@NotNull
	@Size(min =3,max = 40)
	private String address;
}

















