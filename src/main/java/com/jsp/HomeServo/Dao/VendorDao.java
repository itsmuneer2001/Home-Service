package com.jsp.HomeServo.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.Dto.Vendor;
import com.jsp.HomeServo.Repo.VendorRepo;

@Repository
public class VendorDao {
	@Autowired
	private VendorRepo repo;
	@Autowired
	private WorkDao workDao;
	@Autowired
	private com.jsp.HomeServo.Dto.Work workDto;

	public Vendor saveVendor(Vendor vendor) {
		return repo.save(vendor);
	}

	public Vendor updateVendor(Vendor vendor) {
		if (repo.findById(vendor.getId()).isPresent()) {
			Vendor dataBase = repo.findById(vendor.getId()).get();
			if (vendor.getName() == null) {
				vendor.setName(dataBase.getName());
				return repo.save(vendor);
			}
		}
		return null;
	}

	public Vendor getByIdVendor(int id) {
		if (repo.findById(id).isPresent()) {
			Vendor vendor = repo.findById(id).get();
			return vendor;
		} else {
			return null;
		}
	}

	public Vendor getByEmailVendor(String email) {
		return repo.findByEmail(email);
	}

	public List<Vendor> getAllVendors() {
		return repo.findAll();
	}

	public Vendor deleteVendors(int id) {
		if (repo.findById(id).isPresent()) {
			Vendor dataBase = repo.findById(id).get();

			List<com.jsp.HomeServo.Dto.Work> list = workDao.getListOfWork();
			if (list != null) {
				List<Vendor> updatedVendor = new ArrayList<>();

				for (com.jsp.HomeServo.Dto.Work work : list) {
					List<Vendor> ven = workDto.getList();
					if (ven != null) {
						for (Vendor vendor : ven) {

							if (vendor.getId() != id) {
								updatedVendor.add(vendor);
							}
						}
					}
					workDto.setList(updatedVendor);
					workDao.updateById(workDto);
				}
			}
			dataBase.setCoastPerDay(id);
			repo.deleteById(id);
			return dataBase;
		} else
			return null;
	}
}
//	public Vendor deleteVendor(int id) {
//		Optional<Vendor> optional = repo.findById(id);
//		if (optional != null) {
//			repo.delete(optional.get());
//		}
//		return optional.get();
//	}
