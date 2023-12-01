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

import com.jsp.hospitalmanagementsystem.dto.Branch;
import com.jsp.hospitalmanagementsystem.service.BranchService;
import com.jsp.hospitalmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchService branchService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@Valid @RequestBody Branch branch, @RequestParam int hid, @RequestParam int aid) {

		return branchService.saveBranch(branch, hid, aid);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Branch>> updateBranch( @RequestParam int bid,@Valid @RequestBody Branch branch) {

		return branchService.updateBranch(bid, branch);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int bid) {

		return branchService.deleteBranch(bid);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Branch>> getBranchbyid(@RequestParam int bid) {

		return branchService.getBranchbyid(bid);
	}
}
