package com.jsp.HomeServo.Exception;

public class NoSuchElementFoundByVendor extends RuntimeException{
	private String message="Id is not present";

	public NoSuchElementFoundByVendor(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByVendor() {
		super();
	}
	
	
}
