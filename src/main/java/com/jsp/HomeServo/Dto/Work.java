package com.jsp.HomeServo.Dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Entity
@Component
public class Work {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String typeOfWork;
	private Date startDate;
	private Date endDate;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@ManyToMany
	private List<Vendor> list;
	@ManyToOne
	@JoinColumn 
	private Customer customer;
	@OneToOne
	private ServiceCost coast;
	
}
