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

import com.jsp.hospitalmanagementsystem.dto.Encounter;
import com.jsp.hospitalmanagementsystem.service.EncounterService;
import com.jsp.hospitalmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("/encounter")
public class EncounterController {

	@Autowired
	private EncounterService encounterService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@Valid @RequestBody Encounter encounter,@RequestParam int pid,@RequestParam int bid) {
		
		return encounterService.saveEncounter(encounter, pid, bid);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestParam int eid,@Valid @RequestBody Encounter encounter,@RequestParam int bid) {
		
		return encounterService.updateEncounter( eid,encounter, bid);
	}
	
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int eid) {
		
		return encounterService.deleteEncounter(eid);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterbyid(@RequestParam int eid) {
		
		return encounterService.getEncounterbyid(eid);
	}
}
