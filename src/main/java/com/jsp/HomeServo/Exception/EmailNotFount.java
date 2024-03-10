package com.jsp.HomeServo.Exception;

import lombok.Data;

@Data
public class EmailNotFount extends RuntimeException{
	private String message="enter currect email";

	public EmailNotFount(String message) {
		super();
		this.message = message;
	}

	public EmailNotFount() {
		super();
	}
	

}
