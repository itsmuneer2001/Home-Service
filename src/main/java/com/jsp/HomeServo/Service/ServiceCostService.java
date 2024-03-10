package com.jsp.HomeServo.Service;

import java.sql.Date;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.Dao.CustomerDao;
import com.jsp.HomeServo.Dao.ServiceCostDao;
import com.jsp.HomeServo.Dao.VendorDao;
import com.jsp.HomeServo.Dao.WorkDao;
import com.jsp.HomeServo.Dto.Customer;
import com.jsp.HomeServo.Dto.ServiceCost;
import com.jsp.HomeServo.Dto.Vendor;
import com.jsp.HomeServo.Dto.Work;
import com.jsp.HomeServo.Exception.NoSuchElementFoundByVendor;
import com.jsp.HomeServo.util.ResponseStructure;

@Service
public class ServiceCostService {
	@Autowired
	private ServiceCostDao coastDao;
	@Autowired
	private WorkDao workDao;
	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private ServiceCost serviceCoast;
	@Autowired
	private CustomerDao customerDao;

	public ResponseEntity<ResponseStructure<ServiceCost>> saveGetAmount(int work_id, int ven_id) {
		Vendor vendor = vendorDao.getByIdVendor(ven_id);
		if (vendor != null) {
			Work work = workDao.getWorkById(work_id);
			if(work!=null) {
				double coastPerDay=vendor.getCoastPerDay();
				Date start=work.getStartDate();
				Date end=work.getEndDate();
				Duration duration=Duration.between(start.toLocalDate().atStartOfDay(), end.toLocalDate().atStartOfDay());
				int days=(int)duration.toDays();
				ServiceCost serviceCost=new ServiceCost();
				serviceCoast.setDays(days);
				serviceCoast.setTotalAmount(days*coastPerDay);
				ServiceCost serviceCoast2=coastDao.saveServiceCoast(serviceCoast);
				work.setCoast(serviceCoast2);
				List<ServiceCost> list=new ArrayList<ServiceCost>();
				list.add(serviceCoast2);
				list.addAll(vendor.getCoast());
				vendor.setCoast(list);
				vendorDao.updateVendor(vendor);
				workDao.updateById(work);
				ResponseStructure<ServiceCost> structure=new ResponseStructure<>();
				structure.setData(serviceCoast2);
				structure.setMessage("cost saved successfull");
				structure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<ServiceCost>>(structure,HttpStatus.CREATED);
				
			}
			else {
				throw new NoSuchElementFoundByVendor();
			}
		} else {
			throw new NoSuchElementFoundByVendor();
		}
	}
	public ResponseEntity<ResponseStructure<ServiceCost>> payment(int cus_id,ServiceCost coast){
		Customer customer=customerDao.getByIdCustomer(cus_id);
		if(customer!=null) {
			ServiceCost serviceCoast=coastDao.getServiceCost(cus_id);
			if(serviceCoast!=null) {
				ResponseStructure<ServiceCost> structure=new ResponseStructure<>();
				structure.setData(coastDao.payServiceCoast(coast));
				structure.setMessage("payment is successfull");
				structure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<ServiceCost>>(structure,HttpStatus.CREATED);
			}
			else {
				throw new NoSuchElementFoundByVendor();
			}
		}
		else {
		return null;
		}
	}
}
