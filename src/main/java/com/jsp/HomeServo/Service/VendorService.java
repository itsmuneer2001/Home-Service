package com.jsp.HomeServo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.Dao.CustomerDao;
import com.jsp.HomeServo.Dao.VendorDao;
import com.jsp.HomeServo.Dto.Vendor;
import com.jsp.HomeServo.Exception.EmailNotFount;
import com.jsp.HomeServo.Exception.NoSuchElementFoundByCustomer;
import com.jsp.HomeServo.Exception.NoSuchElementFoundByVendor;
import com.jsp.HomeServo.Exception.PasswordNotFound;
import com.jsp.HomeServo.util.ResponseStructure;

@Service
public class VendorService {
	@Autowired
	private VendorDao dao;
	@Autowired
	private CustomerDao customerDao;
	
	//if want same(POSTMAN AND OUR STATUS)status then we want for ResponseEntity(Enum)
	// FOUND and CREATED is costraines are in Enum of ResponceEntity
	
	public ResponseEntity<ResponseStructure<Vendor>> saveVendor(Vendor vendor) {
		ResponseStructure<Vendor> structure = new ResponseStructure<>();
		structure.setData(dao.saveVendor(vendor));
		structure.setMessage("data saved succesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Vendor>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Vendor>> updateVnVendor(Vendor vendor) {
		ResponseStructure<Vendor> structure = new ResponseStructure<>();
		structure.setData(dao.updateVendor(vendor));
		structure.setMessage("data updated successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Vendor>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Vendor>> getByIdVendor(int id) {
		Vendor vendor=dao.getByIdVendor(id);
		ResponseStructure<Vendor> structure = new ResponseStructure<>();
		if(vendor!=null) {
			structure.setData(dao.getByIdVendor(id));
			structure.setMessage("data fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Vendor>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new NoSuchElementFoundByVendor();
		}
	}
	public ResponseEntity<ResponseStructure<Vendor>> login(String email,String password){
		Vendor vendor=dao.getByEmailVendor(email);
		if(vendor!=null) {
			if(vendor.getPassword().equals(password)) {
				ResponseStructure<Vendor> structure=new ResponseStructure<>();
				structure.setData(vendor);
				structure.setMessage("login succesfull");
				structure.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<ResponseStructure<Vendor>>(structure,HttpStatus.FOUND);
			}
			else {
				throw new PasswordNotFound();
			}
		}
		else {
			throw new EmailNotFount();
		}
	}
	public ResponseEntity<ResponseStructure<Vendor>> deleteVendor(int id) {
		Vendor vendor=dao.deleteVendors(id);
		ResponseStructure<Vendor> structure = new ResponseStructure<>();
		if(vendor!=null) {
			structure.setData(dao.deleteVendors(id));
			structure.setMessage("data deleteded successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Vendor>>(structure, HttpStatus.FOUND);
		}
		else {
			throw new NoSuchElementFoundByVendor();
		}
	}
	public ResponseEntity<ResponseStructure<List<Vendor>>> getAllVendors(int cus_id) {
		if(cus_id!=0) {
			
		
		ResponseStructure<List<Vendor>> structure = new ResponseStructure<>();
		structure.setData(dao.getAllVendors());
		structure.setMessage("data fetched successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Vendor>>>(structure, HttpStatus.FOUND);
		}
		else {
			throw new NoSuchElementFoundByCustomer();
		}
	}

}
