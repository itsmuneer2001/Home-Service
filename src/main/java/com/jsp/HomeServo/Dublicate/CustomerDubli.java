package com.jsp.HomeServo.Dublicate;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CustomerDubli {
	
	private int id;
	private String name;
	private String email;
	private long phone;
	private int familyCount;
}
