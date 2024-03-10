package com.jsp.HomeServo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.Dto.Work;
import com.jsp.HomeServo.Service.WorkService;
import com.jsp.HomeServo.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;

@RestController
public class WorkController {
	@Autowired
	private WorkService service;
	
	@ApiOperation(value = "UPLODE WORK BY CUSTOMER OPERATION")
	
	@PostMapping("/works")
	public ResponseEntity<ResponseStructure<Work>> saveWork(@RequestBody Work work,@RequestParam int cus_id) {
		return service.saveWork(work, cus_id);
	}
	
	@ApiOperation(value = "START WORK BY VENDOR OPERATION")
	
	@PutMapping("/start")
	public ResponseEntity<ResponseStructure<Work>> startDate(@RequestParam int work_id,@RequestParam int ven_id) {
		return service.startDate(work_id, ven_id);
	}
	
	@ApiOperation(value = "END WORK BY VENDOR OPERATION")
	
	@PutMapping("/end")
	public ResponseEntity<ResponseStructure<Work>> endDate(@RequestParam int work_id,@RequestParam int ven_id) {
		return service.endDate(work_id, ven_id);
	}
	
	@ApiOperation(value = "ALL WORK DETAILS OPERATION ")
	
	@GetMapping("/worksgetall")
	public ResponseEntity<ResponseStructure<List<Work>>> getAllOfWork(@RequestParam int ven_id) {
		return service.getAll(ven_id);
	}
	
	@ApiOperation(value = "GET WORK DETAILS OPERATION ")
	
	 @GetMapping("/works")
	public ResponseEntity<ResponseStructure<Work>> getWorkById(@RequestParam int ven_id,@RequestParam int work_id) {
		return service.getWorkById(ven_id, work_id);
	}
}
