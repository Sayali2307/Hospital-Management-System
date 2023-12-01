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

import com.jsp.hospitalmanagementsystem.dto.Medorder;
import com.jsp.hospitalmanagementsystem.service.MedorderService;
import com.jsp.hospitalmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("/medorder")
public class MedorderController {

	@Autowired
	private MedorderService medorderService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Medorder>> saveMedorder(@Valid @RequestBody Medorder medorder, @RequestParam int eid) {

		return medorderService.saveMedorder(medorder, eid);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Medorder>> updateMedorder(@RequestParam int mid,@Valid @RequestBody Medorder medorder) {
		return medorderService.updateMedorder(mid, medorder);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Medorder>> deleteMedorder(@RequestParam int mid) {
		
		return medorderService.deleteMedorder(mid);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Medorder>> getMedorderbyid(@RequestParam int mid) {
		
		return medorderService.getMedorderbyid(mid);
	}
}
