package com.jsp.HomeServo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.Dto.Customer;
import com.jsp.HomeServo.Dublicate.CustomerDubli;
import com.jsp.HomeServo.Service.CustomerService;
import com.jsp.HomeServo.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;

@RestController
@ApiOperation(value = "CUSTOMER")
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@ApiOperation(value = "CUSTOMER REGISTER OPERATION")
	
	@PostMapping("/customers")
	public ResponseEntity<ResponseStructure<Customer>> save(@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}
	
	@ApiOperation(value = "CUSTOMER UPDATE OPERATION")
	
	@PutMapping("/customers")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	
	@ApiOperation(value = "CUSTOMER DETAILS FETCH OPERATION")
	
	@GetMapping("/customers")
	public ResponseEntity<ResponseStructure<CustomerDubli>> getByIdCustomer(@RequestParam int id) {
		return service.getByIdCustomerDubli(id);
	}
	
	@ApiOperation(value = "CUSTOMERS DELETE OPERATION")
	
	@DeleteMapping("/customers")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@RequestParam int id) {
		return service.deleteCustomer(id);
	}
//	@GetMapping("/customers")
//	public List<Customer> getByAll(){
//		return service.getByAll();
//	}
//	@GetMapping("/customers/login")
//	public ResponseEntity<ResponseStructure<Customer>> login(@RequestParam String email , @RequestParam String password){
//		return service.login(email, password);
//	}

}
