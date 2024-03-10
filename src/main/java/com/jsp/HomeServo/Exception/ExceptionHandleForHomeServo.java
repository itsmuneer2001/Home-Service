package com.jsp.HomeServo.Exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.HomeServo.util.ResponseStructure;

@ControllerAdvice
public class ExceptionHandleForHomeServo extends ResponseEntityExceptionHandler {
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> SQLIntegrityConstraintViolationException(
			SQLIntegrityConstraintViolationException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("dont inserd dublicate email id ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmailNotFount.class)
	public ResponseEntity<ResponseStructure<String>> emailNotFoundCustomer(EmailNotFount ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Enter currect Email");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PasswordNotFound.class)
	public ResponseEntity<ResponseStructure<String>> passwordNotFoundCustomer(PasswordNotFound pass) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Enter currect password");
		structure.setMessage(pass.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
//	@ExceptionHandler(EmailNotFount.class)
//	public ResponseEntity<ResponseStructure<String>> emailNotFountVendor(EmailNotFount e){
//		ResponseStructure<String> structure=new ResponseStructure<>();
//		structure.setData("enter the cuurect email");
//		structure.setMessage(e.getMessage());
//		structure.setStatus(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
//	}
//	@ExceptionHandler(PasswordNotFound.class)
//	public ResponseEntity<ResponseStructure<String>> passwordNotFound(PasswordNotFound p){
//		ResponseStructure<String> structure=new ResponseStructure<>();
//		structure.setData("enter the cuurect email");
//		structure.setMessage(p.getMessage());
//		structure.setStatus(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
//	
//	}.

	@ExceptionHandler(NoSuchElementFoundByCustomer.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementFoundByCustomer(NoSuchElementFoundByCustomer id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Enter currect id");
		structure.setMessage(id.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchElementFoundByVendor.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementFoundByVendor(NoSuchElementFoundByVendor id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Enter currect Id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(id.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
