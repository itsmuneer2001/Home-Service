package com.jsp.HomeServo.Exception;

import lombok.Data;

@Data
public class PasswordNotFound extends RuntimeException{
	private String message="password is not currect";

	public PasswordNotFound(String message) {
		super();
		this.message = message;
	}

	public PasswordNotFound() {
		super();
	}
	
	
}
