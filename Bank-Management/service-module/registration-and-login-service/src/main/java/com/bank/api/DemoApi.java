package com.bank.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Customer;
import com.bank.service.RegistrationServiceInterface;

@RestController
@RequestMapping(value = "/customer")
public class DemoApi {
	
	@Autowired
	RegistrationServiceInterface register;
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable String id){
		Customer customer=register.findCustomerById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/details/{PAN}")
	public ResponseEntity<Customer> getCustomerByPAN(@PathVariable String PAN){
		return new ResponseEntity<Customer>(register.findCustomerByPAN(PAN), HttpStatus.OK);
	}
	
	@PostMapping("/detail")
	public ResponseEntity<Customer> creeateCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(register.createCustomer(customer), HttpStatus.OK);
	}
}
