package com.jsp.hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalmanagementsystem.dao.PersonDao;
import com.jsp.hospitalmanagementsystem.dto.Hospital;
import com.jsp.hospitalmanagementsystem.dto.Person;
import com.jsp.hospitalmanagementsystem.exception.Idnotfound;
import com.jsp.hospitalmanagementsystem.util.ResponseStructure;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {

		ResponseStructure<Person> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully Saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(personDao.savePerson(person));
		return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.CREATED);	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(int pid, Person person) {

		Person person2 = personDao.updatePerson(pid, person);
		ResponseStructure<Person> responseStructure = new ResponseStructure<>();

		if (person2 != null) {

			responseStructure.setMessage("Succesfully updated");

			responseStructure.setStatus(HttpStatus.OK.value());

			responseStructure.setData(person2);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		} else { 

			throw new Idnotfound("Id not found for the hospital");	
			}
		}
	

	public ResponseEntity<ResponseStructure<Person>> deletePerson(int pid) {

		Person person = personDao.deletePerson(pid);
		ResponseStructure<Person> responseStructure = new ResponseStructure<>();

		if (person != null) {
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);

		} else {
			throw new Idnotfound("Id not found for the hospital");	
			}
		}
	

	public ResponseEntity<ResponseStructure<Person>> getPersonbyid(int aid) {

		Person person = personDao.getPersonbyid(aid);
		ResponseStructure<Person> responseStructure = new ResponseStructure<>();

		if (person != null) {

			responseStructure.setMessage("Successfully found");

			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.FOUND);
			
		} else {
			throw new NoSuchElementException("No id found")	;
		}
	}
}
