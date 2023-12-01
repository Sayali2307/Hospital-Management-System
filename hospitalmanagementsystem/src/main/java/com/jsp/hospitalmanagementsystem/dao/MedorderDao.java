package com.jsp.hospitalmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospitalmanagementsystem.dto.Encounter;
import com.jsp.hospitalmanagementsystem.dto.Medorder;
import com.jsp.hospitalmanagementsystem.repo.MedorderRepo;

@Repository
public class MedorderDao {

	@Autowired
	private MedorderRepo medorderRepo;

	@Autowired
	private EncounterDao encounterDao;

	public Medorder saveMedorder(Medorder medorder, int eid) {

		Encounter encounter = encounterDao.getEncounterbyid(eid);
		medorder.setEncounter(encounter);
		return medorderRepo.save(medorder);
	}

	public Medorder updateMedorder(int mid, Medorder medorder) {

		if (medorderRepo.findById(mid).isPresent()) {

			medorder.setMid(mid);
			return medorderRepo.save(medorder);
		} else {
			return null;
		}
	}

	public Medorder deleteMedorderbyid(int mid) {

		if (medorderRepo.findById(mid).isPresent()) {

			Medorder medorder = medorderRepo.findById(mid).get();
			medorderRepo.deleteById(mid);
			return medorder;
		} else {
			return null;
		}
	}

	public Medorder getMedorderbyid(int mid) {

		if (medorderRepo.findById(mid).isPresent()) {

			Medorder medorder = medorderRepo.findById(mid).get();
			return medorder;
		} else {
			return null;
		}
	}

}
