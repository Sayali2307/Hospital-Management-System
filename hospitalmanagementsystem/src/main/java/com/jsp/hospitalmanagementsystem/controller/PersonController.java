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

import com.jsp.hospitalmanagementsystem.dto.Person;
import com.jsp.hospitalmanagementsystem.service.PersonService;
import com.jsp.hospitalmanagementsystem.util.ResponseStructure;


@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Person>> savePerson(@Valid @RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestParam int pid,@Valid @RequestBody Person person) {
		
		return personService.updatePerson(pid, person);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int pid) {
		 return personService.deletePerson(pid);
		
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Person>> getPersonbyid(@RequestParam int pid) {
		
		return personService.getPersonbyid(pid);
	}
}
