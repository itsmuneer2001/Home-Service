package com.jsp.HomeServo.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Entity
@Component
public class ServiceCost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mode;
	private double totalAmount;
	private int days;
	
}
