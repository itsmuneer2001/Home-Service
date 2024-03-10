package com.jsp.HomeServo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.Dto.Address;
import com.jsp.HomeServo.Service.AddressService;
import com.jsp.HomeServo.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;

@RestController
public class AddressController {
	@Autowired
	private AddressService service;
	
	@ApiOperation(value = "GET ADDRESS DETAILS OPERATION ")
	
	@GetMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> getAddress(@RequestParam int id) {
		return service.getAddressById(id);
	}
	@ApiOperation(value = "UPDATE ADDRESS DETAILS OPERATION ")
	
	@PutMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address) {
		return service.updateAddress(address);
	}
//	@DeleteMapping("/address/{id}")
//	public ResponseEntity<ResponseStructure<Address>> delete(@PathVariable int id) {
//		return service.deleteAddressById(id);
//	}
}
