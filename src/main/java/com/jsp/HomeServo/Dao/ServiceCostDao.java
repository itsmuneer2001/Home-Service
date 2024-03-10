package com.jsp.HomeServo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.Dto.ServiceCost;
import com.jsp.HomeServo.Repo.ServiceCostRepo;

@Repository
public class ServiceCostDao {
	@Autowired
	private ServiceCostRepo repo;

	public ServiceCost saveServiceCoast(ServiceCost coast) {
		return repo.save(coast);
	}
	// below method is for updating
	public ServiceCost payServiceCoast(ServiceCost cost) {
		if(repo.findById(cost.getId()).isPresent()) {
			ServiceCost cost2=repo.findById(cost.getId()).get();
			if(cost2!=null) {
				cost2.setMode(cost.getMode());
			}
			return repo.save(cost2);
		}
		else {
			return null;
		}
	}
	public ServiceCost getServiceCost(int id) {
		if(repo.findById(id).isPresent()) {
		ServiceCost cost=repo.findById(id).get();
		return cost;
		
	}
		else {
			return null;
		}
	}

}
