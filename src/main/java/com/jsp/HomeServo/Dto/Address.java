package com.jsp.HomeServo.Dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
@Data
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String d_No;
	private String street;
	private String landMark;
	private String district;
	private String state;
	private int pincode;
//	@OneToOne
//	private Vendor vendor;
//	@OneToOne
//	private List<Work> list;

}
