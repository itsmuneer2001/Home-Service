package com.jsp.HomeServo.util;

import java.util.List;

import com.jsp.HomeServo.Dto.Customer;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private String message;
	private int status;
	private T data;

}

