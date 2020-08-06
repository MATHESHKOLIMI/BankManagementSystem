package com.bank.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	@Email
	private String customerMail;
	@Size(min = 10, max = 13)
	private String mobileNumber;
	@Pattern(regexp = "[1-9][0-9] {9}")
	private String customerAccountNumber;
	@NotNull
	@Min(value = 8)
	@Max(value = 16)
	private String password;
	@NotNull
	@Size(min =3,max = 40)
	private String address;
}
