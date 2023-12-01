package com.jsp.hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalmanagementsystem.dao.HospitalDao;
import com.jsp.hospitalmanagementsystem.dto.Hospital;
import com.jsp.hospitalmanagementsystem.exception.Idnotfound;
import com.jsp.hospitalmanagementsystem.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao hospitalDao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {

		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully Saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(hospitalDao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int hid, Hospital hospital) {

		Hospital hospital2 = hospitalDao.updateHospital(hid, hospital);

		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();

		if (hospital2 != null) {
			responseStructure.setMessage("Succesfully updated");

			responseStructure.setStatus(HttpStatus.OK.value());

			responseStructure.setData(hospital2);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		} else {

			throw new Idnotfound("Id not found for the hospital");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int hid) {

		Hospital hospital = hospitalDao.deleteHospital(hid);

		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();

		if (hospital != null) {
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);

		} else {
			throw new Idnotfound("Id not found for the hospital");		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalbyid(int hid) {

		Hospital hospital = hospitalDao.getHospitalbyid(hid);

		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();

		if (hospital != null) {
			responseStructure.setMessage("Successfully found");

			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.FOUND);
		} else {

			throw new NoSuchElementException("No id found")	;
			
		}
	}
	

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalbyemail(String email) {

		Hospital hospital = hospitalDao.getHospitalByemail(email);

		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();

		if (hospital != null) {
			responseStructure.setMessage("Successfully found");

			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.FOUND);
		} else {

			throw new NoSuchElementException("No id found")	;
			
		}
	}
}
