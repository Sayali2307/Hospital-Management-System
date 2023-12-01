package com.jsp.hospitalmanagementsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospitalmanagementsystem.dto.Hospital;
import com.jsp.hospitalmanagementsystem.service.HospitalService;
import com.jsp.hospitalmanagementsystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	@ApiOperation(value = "save hospital",notes = "api is used to save hospital")
	@ApiResponses(value = {@ApiResponse(code =201,message = "successfully saved" )})
	@PostMapping
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital) {
		
		return hospitalService.saveHospital(hospital);
	}
	
	
	
	@ApiOperation(value = "update hospital",notes = "api is used to update hospital")
	@ApiResponses(value = {@ApiResponse(code =200,message = "successfully updated" ),@ApiResponse(code = 404,message = "id not found")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int hid,@Valid @RequestBody Hospital hospital) {
		
		return hospitalService.updateHospital(hid, hospital);
	}
	
	
	@ApiOperation(value = "delete hospital",notes = "api is used to delete hospital")
	@ApiResponses(value = {@ApiResponse(code =200,message = "successfully deleted" ),@ApiResponse(code = 404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@RequestParam int hid) {
		
		return hospitalService.deleteHospital(hid);
	}
	
	
	@ApiOperation(value = "get hospital by id",notes = "api is used to get hospital based on id")
	@ApiResponses(value = {@ApiResponse(code =302,message = "successfully found" ),@ApiResponse(code = 404,message = "id not found")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalbyid(@RequestParam int hid) {
		
		return hospitalService.getHospitalbyid(hid);
	}
	
	
	@ApiOperation(value = "get hospital by email",notes = "api is used to get hospital based on email")
	@ApiResponses(value = {@ApiResponse(code =302,message = "successfully found" ),@ApiResponse(code = 404,message = "id not found")})
	@GetMapping("/getbyemail")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalbyemail(@RequestParam String  email) {
		
		return hospitalService.getHospitalbyemail(email);
	}
	
	
}
