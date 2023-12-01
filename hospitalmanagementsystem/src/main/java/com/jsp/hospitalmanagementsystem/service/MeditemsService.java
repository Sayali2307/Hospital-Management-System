package com.jsp.hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalmanagementsystem.dao.MeditemDao;
import com.jsp.hospitalmanagementsystem.dto.Hospital;
import com.jsp.hospitalmanagementsystem.dto.Meditems;
import com.jsp.hospitalmanagementsystem.exception.Idnotfound;
import com.jsp.hospitalmanagementsystem.util.ResponseStructure;

@Service
public class MeditemsService {

	@Autowired
	private MeditemDao meditemDao;

	public ResponseEntity<ResponseStructure<Meditems>> saveMeditems(Meditems meditems, int mid) {

		ResponseStructure<Meditems> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully Saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(meditemDao.saveMeditems(meditems, mid));
		return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Meditems>> updateMeditems(int id, Meditems meditems) {

		Meditems meditems2 = meditemDao.getMeditemsbyid(id);

		meditems.setMedorder(meditems2.getMedorder());

		Meditems dbMeditems = meditemDao.updateMeditems(id, meditems2);

		ResponseStructure<Meditems> responseStructure = new ResponseStructure<>();

		if (dbMeditems != null) {

			responseStructure.setMessage("Succesfully updated");

			responseStructure.setStatus(HttpStatus.OK.value());

			responseStructure.setData(dbMeditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure, HttpStatus.OK);

		} else {
			throw new Idnotfound("Id not found for the hospital");
		}
	}

	public ResponseEntity<ResponseStructure<Meditems>> deleteMeditems(int id) {

		Meditems meditems = meditemDao.deleteMeditems(id);
		ResponseStructure<Meditems> responseStructure = new ResponseStructure<>();

		if (meditems != null) {
			
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(meditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure, HttpStatus.OK);

			
		} else {
			throw new Idnotfound("Id not found for the hospital");
		}
	}

	public ResponseEntity<ResponseStructure<Meditems>> getMeditemsbyid(int id) {

		Meditems meditems = meditemDao.getMeditemsbyid(id);
		ResponseStructure<Meditems> responseStructure = new ResponseStructure<>();

		if (meditems != null) {

			responseStructure.setMessage("Successfully found");

			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(meditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure, HttpStatus.FOUND);
		}  else {
			throw new NoSuchElementException("No id found")	;
		}
	}
}
