package com.jsp.HomeServo.Exception;

import lombok.Data;

@Data
public class NoSuchElementFoundByCustomer extends RuntimeException{
	private String message="plz insert currect id";

	public NoSuchElementFoundByCustomer(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByCustomer() {
		super();
	}
	

	
	

}
