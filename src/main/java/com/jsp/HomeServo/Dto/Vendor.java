 package com.jsp.HomeServo.Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
@Data
@Entity
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	private long phoneNo;
	private String role;
	private double coastPerDay;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToMany(cascade = CascadeType.ALL)
	private List<ServiceCost> coast;
	

}
