package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Issues;
import com.example.demo.repository.BugTrackerRepository;

@Service
public class BugTrackerService {
	
	@Autowired
	private BugTrackerRepository repo;
	
	public List<Issues> findAll(Pageable pageable){
		
		Page<Issues> pages=this.repo.findAll(pageable);
		
		return pages.getContent();
	}
	
	public Optional<Issues> findIssuesById(int id){
		
		return this.repo.findById(id);
	}
	
	public Issues saveIssue(Issues issue) {
		
		return this.repo.save(issue);
	}

}
