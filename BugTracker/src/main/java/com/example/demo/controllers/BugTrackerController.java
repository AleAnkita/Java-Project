package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Issues;
import com.example.demo.services.BugTrackerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/rest")
public class BugTrackerController {

	@Autowired
	private BugTrackerService service;
	
	//{{url}}/api/rest/issues?page_size=10&page=0
	@GetMapping(path = "/issues")
	public List<Issues> findAllIssues(@RequestParam(defaultValue = "0") int page, 			
		@RequestParam(defaultValue = "10") int page_size) { 
		Pageable pageable = PageRequest.of(page, page_size); 
		return this.service.findAll(pageable);
	}

	//{{url}}/api/rest/issues/issue_id/
	@GetMapping(path = "/issues/{issueId}")
	public Optional<Issues> findyIssueById(@PathVariable("issueId") int id) {
		return this.service.findIssuesById(id);
	}

	//{{url}}/api/rest/issues
	@PostMapping(path = "/issues")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Issues postIssue(@RequestBody Issues issue) {

		return this.service.saveIssue(issue);
	}
}
