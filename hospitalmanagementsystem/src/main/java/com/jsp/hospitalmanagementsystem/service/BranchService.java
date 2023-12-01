package com.jsp.hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalmanagementsystem.dao.BranchDao;
import com.jsp.hospitalmanagementsystem.dto.Branch;
import com.jsp.hospitalmanagementsystem.dto.Hospital;
import com.jsp.hospitalmanagementsystem.exception.Idnotfound;
import com.jsp.hospitalmanagementsystem.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, int hid, int aid) {

		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully Saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch, hid, aid));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int bid, Branch branch) {

		Branch branch2 = branchDao.updateBranch(bid, branch);
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();

		if (branch2 != null) {
			responseStructure.setMessage("Succesfully updated");

			responseStructure.setStatus(HttpStatus.OK.value());

			responseStructure.setData(branch2);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new Idnotfound("Id not found for the branch");		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int bid) {

		Branch branch = branchDao.deleteBranch(bid);
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();

		if (branch != null) {
			
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new Idnotfound("Id not found for the branch");		}
	}

	public ResponseEntity<ResponseStructure<Branch>> getBranchbyid(int bid) {

		Branch branch = branchDao.getBranchbyid(bid);
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();

		if (branch != null) {
			
			responseStructure.setMessage("Successfully found");

			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("No id found");
		}
	}

}
