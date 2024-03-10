package com.jsp.HomeServo.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.Dao.CustomerDao;
import com.jsp.HomeServo.Dao.VendorDao;
import com.jsp.HomeServo.Dao.WorkDao;
import com.jsp.HomeServo.Dto.Customer;
import com.jsp.HomeServo.Dto.Vendor;
import com.jsp.HomeServo.Dto.Work;
import com.jsp.HomeServo.Exception.NoSuchElementFoundByCustomer;
import com.jsp.HomeServo.Exception.NoSuchElementFoundByVendor;
import com.jsp.HomeServo.util.ResponseStructure;

@Service
public class WorkService {
	@Autowired
	private WorkDao dao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private VendorDao vendorDao;

	public ResponseEntity<ResponseStructure<Work>> saveWork(Work work, int cus_id) {
		Customer cus = customerDao.getByIdCustomer(cus_id);
		if (cus != null) {
			ResponseStructure<Work> structure = new ResponseStructure<>();
			work.setCustomer(cus);
			structure.setData(dao.saveWork(work));
			structure.setMessage("saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Work>>(structure, HttpStatus.CREATED);
		} else {
			throw new NoSuchElementFoundByCustomer();
		}
	}

	public ResponseEntity<ResponseStructure<Work>> startDate(int work_id, int ven_id) {
		Vendor vendor = vendorDao.getByIdVendor(ven_id);
		if (vendor != null) {
			Work work = dao.getWorkById(work_id);

			if (work != null) {
				Date date = new Date(new java.util.Date().getTime());
				work.setStartDate(date);
				List<Vendor> list = new ArrayList<>();
				list.add(vendor);
				work.setList(list);
				ResponseStructure<Work> structure = new ResponseStructure<>();
				structure.setData(dao.saveWork(work));
				structure.setMessage("saved successfully");
				structure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<Work>>(structure, HttpStatus.CREATED);
			}

			else {
				throw new NoSuchElementFoundByVendor();
			}
		} else {
			throw new NoSuchElementFoundByVendor();
		}

	}

	public ResponseEntity<ResponseStructure<Work>> endDate(int work_id, int ven_id) {
		Vendor vendor = vendorDao.getByIdVendor(ven_id);
		if (vendor != null) {
			Work work = dao.getWorkById(work_id);
			if (work != null) {
				Date date=new Date(new java.util.Date().getTime());
				work.setEndDate(date);
				ResponseStructure<Work> structure = new ResponseStructure<>();
				structure.setData(dao.saveWork(work));
				structure.setMessage("successfully completed your work");
				structure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<Work>>(structure, HttpStatus.CREATED);
			} else {
				throw new NoSuchElementFoundByVendor();
			}
		} else {
			throw new NoSuchElementFoundByVendor();
		}

	}
	public ResponseEntity<ResponseStructure<List<Work>>> getAll(int ven_id){
		
		Vendor vendor =vendorDao.getByIdVendor(ven_id);
		if(vendor!=null) {
			List<Work> list=dao.getListOfWork();
			ResponseStructure<List<Work>> structure=new ResponseStructure<>();
			structure.setMessage("data fetchrd successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Work>>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new NoSuchElementFoundByVendor();
		}
	}
	public ResponseEntity<ResponseStructure<Work>> getWorkById(int ven_id,int work_id){
		Vendor vendor=vendorDao.getByIdVendor(ven_id);
		if(vendor!=null) {
			ResponseStructure<Work> structure=new ResponseStructure<>();
			structure.setMessage("data fetchrd successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.getWorkById(work_id));
			return new ResponseEntity<ResponseStructure<Work>>(structure,HttpStatus.FOUND);
			
		}
		else {
			throw new NoSuchElementFoundByVendor();
		}
	}

}
