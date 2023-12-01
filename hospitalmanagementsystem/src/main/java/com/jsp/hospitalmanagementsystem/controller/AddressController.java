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

import com.jsp.hospitalmanagementsystem.dto.Address;
import com.jsp.hospitalmanagementsystem.service.AddressService;
import com.jsp.hospitalmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid @RequestBody Address address) {
		
		return addressService.saveAddress(address);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int aid,@Valid @RequestBody Address address) {
		
		
		return addressService.updateAddress(aid,address);
	}
	
	@DeleteMapping
	public  ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int aid) {
		
		return addressService.deleteAddress(aid);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> getAddressbyid(@RequestParam int aid) {
		
		return addressService.getAddressbyid(aid);
	}
}
