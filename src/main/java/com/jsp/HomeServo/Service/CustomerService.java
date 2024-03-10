package com.jsp.HomeServo.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.Dao.CustomerDao;
import com.jsp.HomeServo.Dto.Customer;
import com.jsp.HomeServo.Dublicate.CustomerDubli;
import com.jsp.HomeServo.Exception.EmailNotFount;
import com.jsp.HomeServo.Exception.NoSuchElementFoundByCustomer;
import com.jsp.HomeServo.Exception.PasswordNotFound;
import com.jsp.HomeServo.util.ResponseStructure;


@Service
public class CustomerService {
	@Autowired
	private CustomerDao dao;
	
	@Autowired(required = true)
	 private ModelMapper  mapper;
	@Autowired
	CustomerDubli customerDubli;
//if want same(POSTMAN AND OUR STATUS)status then we want for ResponseEntity
	
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		structure.setData(dao.saveCustomer(customer));
		structure.setMessage("data saved sussesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);

	}
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer) {
		ResponseStructure<Customer> structure=new ResponseStructure<>();
		structure.setData(dao.update(customer));
		structure.setMessage("updated succussfully");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
		
	}
//	public ResponseEntity<ResponseStructure<Customer>> getByIdCustomer(int id) {
//		 Customer customer=dao.getByIdCustomer(id);
//		ResponseStructure<Customer> structure=new ResponseStructure<>();
//		if(customer!=null) {
//			structure.setData(customer);
//			structure.setMessage("successfully fetched data");
//			structure.setStatus(HttpStatus.FOUND.value());
//			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
//		}
//		else {
//			throw new NoSuchElementFoundByCustomer("customer id is not found for your id  "+id+"  to display");
//		}
//		
//	}
	public List<Customer> getByAll() {
	return dao.getByAll();
	}
	public ResponseEntity<ResponseStructure<Customer>> login(String email,String password) {
		Customer customer=dao.getByemail(email);
		
		if(customer!=null) {
			if(customer.getPassword().equals(password)) {
				ResponseStructure<Customer> structure=new ResponseStructure<>();
				structure.setData(customer);
				structure.setMessage("customer login succssfully");
				structure.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
			}
			else {
				throw new PasswordNotFound();
			}
		}
		else {
			throw new EmailNotFount();
		}
	}
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int id) {
		Customer customer=dao.deleteCustomer(id);
		ResponseStructure<Customer> structure=new ResponseStructure<>();
		if(customer!=null) {
			structure.setData(dao.deleteCustomer(id));
			structure.setMessage("data deleted successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
			
		}
		else {
			throw new NoSuchElementFoundByCustomer("customer id is not found for your id  "+  id   +"  to display");
		}
		
	}
	public ResponseEntity<ResponseStructure<CustomerDubli>> getByIdCustomerDubli(int id) {
		 Customer customer=dao.getByIdCustomer(id);
		ResponseStructure<CustomerDubli> structure=new ResponseStructure<>();
		if(customer!=null) {
//			customerDubli.setId(customer.getId());
//			customerDubli.setName(customer.getName());
//			customerDubli.setEmail(customer.getEmail());
//			customerDubli.setPhone(customer.getPhone());
			
			//Modelmapper for we are fetching data by inbuilt class
			
			CustomerDubli customerDubli=(CustomerDubli)mapper.map(customer, CustomerDubli.class);
			structure.setData(customerDubli);
			structure.setMessage("succfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<CustomerDubli>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new NoSuchElementFoundByCustomer("customer id is not found for your id  "+id+"  to display");
		}
		
	}

}
