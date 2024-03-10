package com.jsp.HomeServo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jsp.HomeServo.Dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	//here @query annotation is not required because findByEmail JVM will understand
	public Customer findByEmail(String email);
	
}
