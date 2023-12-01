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

import com.jsp.hospitalmanagementsystem.dto.Meditems;
import com.jsp.hospitalmanagementsystem.service.MeditemsService;
import com.jsp.hospitalmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("/meditems")
public class MeditemsController {

	@Autowired
	private MeditemsService meditemsService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Meditems>> saveMeditems(@Valid @RequestBody Meditems meditems,@RequestParam int mid) {
		
		return meditemsService.saveMeditems(meditems, mid);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Meditems>> updateMeditems(@RequestParam int id,@Valid @RequestBody Meditems meditems) {
		
		return meditemsService.updateMeditems(id, meditems);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Meditems>> deleteMeditems(@RequestParam int id) {
		
		return meditemsService.deleteMeditems(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Meditems>> getMeditemsbyid(@RequestParam int id) {
		
		return meditemsService.getMeditemsbyid(id);
	}
}
