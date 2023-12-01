package com.jsp.hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalmanagementsystem.dao.AddressDao;
import com.jsp.hospitalmanagementsystem.dto.Address;
import com.jsp.hospitalmanagementsystem.dto.Hospital;
import com.jsp.hospitalmanagementsystem.exception.Idnotfound;
import com.jsp.hospitalmanagementsystem.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {

		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully Saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
		
	}	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int aid,Address address) {
		
		Address address2=addressDao.updateAddress(aid,address);
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
	
		if (address2!=null) {
			responseStructure.setMessage("Succesfully updated");

			responseStructure.setStatus(HttpStatus.OK.value());

			responseStructure.setData(address2);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new Idnotfound("Id not found for the Address");		}
		}
	
		
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int aid) {
		
		Address address1= addressDao.deleteAddress(aid);
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
	
		if (address1!=null) {
			
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address1);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new Idnotfound("Id not found for the address");		}
 
		}
	
	
	public ResponseEntity<ResponseStructure<Address>> getAddressbyid(int hid) {

		Address address = addressDao.getAddressbyid(hid);

		ResponseStructure<Address> responseStructure = new ResponseStructure<>();

		if (address != null) {
			responseStructure.setMessage("Successfully found");

			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		} else {

			throw new NoSuchElementException("No id found")	;
			
		}
	}}

