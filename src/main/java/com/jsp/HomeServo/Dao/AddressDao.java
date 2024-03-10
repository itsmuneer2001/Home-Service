package com.jsp.HomeServo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.Dto.Address;
import com.jsp.HomeServo.Repo.Addressrepo;

@Repository
public class AddressDao {
	@Autowired
	private Addressrepo repo;

	public Address getAddressById(int id) {
		if (repo.findById(id).isPresent()) {
			Address address = repo.findById(id).get();
			return address;
		}
		return null;
	}
	public Address updateAddress(Address address) {
		if(repo.findById(address.getId()).isPresent()) {
			Address dataBase=repo.findById(address.getId()).get();
			return repo.save(address);
		}
		else {
			return null;
		}
	}

	// delete operation is not required because customer and vendor mapping is there
//	public Address delete(int id) {
//		if (repo.findById(id).isPresent()) {
//			Address address = repo.findById(id).get();
//			return address;
//		}
//		return null;
//	}
	
}
