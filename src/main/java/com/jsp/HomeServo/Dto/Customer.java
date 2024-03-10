package com.jsp.HomeServo.Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
// installing lombok in cmd is (java -jar lombok.jar).in downlod cmd.
@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	private long phone;
	private int familyCount;
	@OneToOne(cascade = CascadeType.ALL)
	
	private Address address;
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Work> work;

}
