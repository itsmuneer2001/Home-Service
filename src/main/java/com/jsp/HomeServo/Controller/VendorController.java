package com.jsp.HomeServo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.Dto.Vendor;
import com.jsp.HomeServo.Service.VendorService;
import com.jsp.HomeServo.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;

@RestController
public class VendorController {
	@Autowired
	private VendorService service;
	
	@ApiOperation(value = "VENDOR REGISTER OPERATION")
	
	@PostMapping("/vendors")
	public ResponseEntity<ResponseStructure<Vendor>> saveVendor(@RequestBody Vendor vendor) {
		return service.saveVendor(vendor);
	}
	@ApiOperation(value = "VENDOR UPDATE OPERATION")
	@PutMapping("/vendors")
	public ResponseEntity<ResponseStructure<Vendor>> updateVendor(@RequestBody Vendor vendor) {
		return service.updateVnVendor(vendor);
	}
	
	@ApiOperation(value = "VENDOR DETAILS FETCH OPERATION")
	
	@GetMapping("/vendors")
	public ResponseEntity<ResponseStructure<Vendor>> getByIdVendor(@RequestParam int id) {
		return service.getByIdVendor(id);
	}
	
	@ApiOperation(value = "VENDOR DELETE OPERATION")
	
	@DeleteMapping("/vendors")
	public ResponseEntity<ResponseStructure<Vendor>> deleteVendor(@RequestParam int id) {
		return service.deleteVendor(id);
	}
	
	@ApiOperation(value = "LIST OF VENDORS DETAILS FETCH OPERATION")
	
	@GetMapping("/vendors/all")
	public ResponseEntity<ResponseStructure<List<Vendor>>> getAllVendors(@RequestParam int cus_id){
		return service.getAllVendors(cus_id);
	}
	
	@ApiOperation(value = "VENDOR LOGIN OPERATION")
	
	@GetMapping("/vendors/login")
	public ResponseEntity<ResponseStructure<Vendor>> login(@RequestParam String email,@RequestParam String password){
		return service.login(email, password);
	}
		
}
