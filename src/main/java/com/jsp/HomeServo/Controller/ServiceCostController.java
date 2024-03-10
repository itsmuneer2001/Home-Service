package com.jsp.HomeServo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.Dto.ServiceCost;
import com.jsp.HomeServo.Service.ServiceCostService;
import com.jsp.HomeServo.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ServiceCostController {
	@Autowired
	private ServiceCostService service;
	
	// if you want to below message in swagger then go for @AoiOper annotation

	@ApiOperation(value = "api for cost save")
	// if you want change status message in swagger then go for below format

	@ApiResponses(value = { @ApiResponse(code = 201, message = "cost saved succssfully"),
			@ApiResponse(code = 404, message = "Vendor or Work id not found") })
	
	@PostMapping("/cost")
	public ResponseEntity<ResponseStructure<ServiceCost>> saveCoast(@RequestParam int work_id,
			@RequestParam int ven_id) {
		return service.saveGetAmount(work_id, ven_id);
	}

	@PutMapping("/payments")
	public ResponseEntity<ResponseStructure<ServiceCost>> payment(@RequestParam int cus_id,
			@RequestBody ServiceCost coast) {
		return service.payment(cus_id, coast);
	}

}
