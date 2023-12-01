package com.jsp.hospitalmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalmanagementsystem.dao.BranchDao;
import com.jsp.hospitalmanagementsystem.dao.EncounterDao;
import com.jsp.hospitalmanagementsystem.dao.PersonDao;
import com.jsp.hospitalmanagementsystem.dto.Branch;
import com.jsp.hospitalmanagementsystem.dto.Encounter;
import com.jsp.hospitalmanagementsystem.dto.Person;
import com.jsp.hospitalmanagementsystem.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao encounterDao;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int eid, int pid) {

		Person person = personDao.getPersonbyid(pid);

		Branch branch = branchDao.getBranchbyid(pid);

		encounter.setPerson(person);

		List<Branch> list = new ArrayList<>();
		list.add(branch);
		encounter.setList(list);

		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully Saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(encounterDao.saveEncounter(encounter));

		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int eid, Encounter encounter, int bid) {

		Encounter encounter2 = encounterDao.getEncounterbyid(eid);

		Branch branch = branchDao.getBranchbyid(bid);

		List<Branch> list = encounter2.getList();

		encounter.setList(encounter2.getList());

		encounter.setPerson(encounter2.getPerson());

		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully updated");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(encounterDao.updateEncounter(eid, encounter));

		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int eid) {

		Encounter encounter = encounterDao.deleteEncounterbyid(eid);

		if (encounter != null) {

			ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);

			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		} else {
			return null;

		}

	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterbyid(int eid) {

		Encounter encounter = encounterDao.getEncounterbyid(eid);

		if (encounter != null) {

			ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Successfully found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(encounter);

			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.FOUND);

		} else {
			return null;

		}

	}
}
