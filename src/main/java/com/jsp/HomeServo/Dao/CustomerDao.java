package com.jsp.HomeServo.Dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.jsp.HomeServo.Dto.Customer;
import com.jsp.HomeServo.Dto.Work;
import com.jsp.HomeServo.Repo.CustomerRepo;
import com.jsp.HomeServo.Repo.WorkRepo;

@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepo cusRepo;
	@Autowired
	private WorkDao workDao;

	public Customer saveCustomer(Customer customer) {
		return cusRepo.save(customer);
	}

	public Customer update(Customer customer) {
		if (cusRepo.findById(customer.getId()).isPresent()) {
			// this is fetching from dataBase
			Customer dataBase = cusRepo.findById(customer.getId()).get();
			if (customer.getPassword() == null) {
				// if we are not updating any field then keep as name
				customer.setPassword(dataBase.getPassword());
			} else if (customer.getEmail() == null) {
				customer.setEmail(dataBase.getEmail());
			} else if (customer.getPhone() == 0) {
				customer.setPhone(dataBase.getPhone());
			} else if (customer.getName() == null) {
				customer.setName(dataBase.getName());
			} else if (customer.getFamilyCount() == 0) {
				customer.setFamilyCount(dataBase.getFamilyCount());
			} else if (customer.getAddress() == null) {
				customer.setAddress(dataBase.getAddress());
			} else if (customer.getWork() == null) {

				customer.setWork(dataBase.getWork());
			}
			return cusRepo.save(customer);
		}
		return null;
	}

	public Customer getByIdCustomer(int id) {
		if (cusRepo.findById(id).isPresent()) {
			Customer customer = cusRepo.findById(id).get();
			return customer;
		} else {
			return null;
		}
	}

	public List<Customer> getByAll() {
		return cusRepo.findAll();
	}

	public Customer getByemail(String email) {
		Customer customer = cusRepo.findByEmail(email);
		if (customer != null) {
			return customer;
		}
		return null;
	}

	public Customer deleteCustomer(int id) {
		if (cusRepo.findById(id).isPresent()) {
			Customer cus = cusRepo.findById(id).get();
			List<Work> list = workDao.getListOfWork();
			if (list != null) {
				for (Work work : list) {
					if (work.getCustomer().getId() == id) {
						work.setCustomer(null);
						workDao.updateById(work);
					}
				}
			}

			cusRepo.deleteById(id);
			return cus;
		} else {
			return null;
		}

	}
//	public Customer delete(int id) {
//		if(rep.findById(id).isPresent()) {
//			Customer customer=rep.findById(id).get();
//			return customer; 
//		}
//		return null;
//	}
}
