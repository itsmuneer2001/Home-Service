package com.jsp.HomeServo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.Dao.AddressDao;
import com.jsp.HomeServo.Dto.Address;
import com.jsp.HomeServo.Exception.NoSuchElementFoundByVendor;
import com.jsp.HomeServo.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;
	
	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id){
		Address address=dao.getAddressById(id);
		if(address!=null) {
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setMessage("data fetched successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.getAddressById(id));
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
 		}
		else {
			throw new NoSuchElementFoundByVendor();
		}
	}
	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address){
		if(address!=null) {
		ResponseStructure<Address> structure=new ResponseStructure<>();
		structure.setMessage("data updated successfully");
		structure.setData(dao.updateAddress(address));
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
	}
		else {
			throw new NoSuchElementFoundByVendor();
		}
	}
//	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int id){
//		Address address=dao.delete(id);
//		if(address!=null) {
//			ResponseStructure<Address> structure=new ResponseStructure<>();
//			structure.setMessage("data deleted successfull");
//			structure.setData(dao.delete(id));
//			structure.setStatus(HttpStatus.FOUND.value());
//			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
//		}
//		else {
//			throw new NoSuchElementFoundByVendor();
//		}
//	}
	

}
