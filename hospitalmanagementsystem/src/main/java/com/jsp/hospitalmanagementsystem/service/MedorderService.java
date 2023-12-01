package com.jsp.hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalmanagementsystem.dao.MedorderDao;
import com.jsp.hospitalmanagementsystem.dto.Hospital;
import com.jsp.hospitalmanagementsystem.dto.Medorder;
import com.jsp.hospitalmanagementsystem.exception.Idnotfound;
import com.jsp.hospitalmanagementsystem.util.ResponseStructure;
@Service
public class MedorderService {

	@Autowired
	private MedorderDao medorderDao;

	public ResponseEntity<ResponseStructure<Medorder>> saveMedorder(Medorder medorder, int eid) {
 
		ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();

		responseStructure.setMessage("Successfully Saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(medorderDao.saveMedorder(medorder, eid));
		return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Medorder>> updateMedorder(int mid, Medorder medorder) {

		Medorder medorder2 = medorderDao.getMedorderbyid(mid);

		medorder.setEncounter(medorder2.getEncounter());

		Medorder dbmedorder = medorderDao.updateMedorder(mid, medorder);

		ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();

		if (dbmedorder != null) {

			responseStructure.setMessage("Succesfully updated");

			responseStructure.setStatus(HttpStatus.OK.value());

			responseStructure.setData(dbmedorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.OK);
			
		}else {
			
		
			throw new Idnotfound("Id not found for the hospital");
		}
	}

	public ResponseEntity<ResponseStructure<Medorder>> deleteMedorder(int hid) {

		Medorder medorder = medorderDao.deleteMedorderbyid(hid);

		ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();

		if (medorder != null) {
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(medorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.OK);

		} else {
			throw new Idnotfound("Id not found for the hospital");
	}
	}

	public ResponseEntity<ResponseStructure<Medorder>> getMedorderbyid(int mid) {

		Medorder medorder = medorderDao.getMedorderbyid(mid);
		ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();

		if (medorder != null) {
			
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(medorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.FOUND);
	
			
		} else {
			throw new NoSuchElementException("No id found")	;
		}
	}
}
