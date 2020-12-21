package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.Issues;
import com.example.demo.repository.BugTrackerRepository;

@SpringBootApplication
public class BugTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			@Autowired
			private BugTrackerRepository repo;
			
			@Override
			public void run(String... args) throws Exception {
				repo.save(new Issues(101,"Compatibility issue","Data is not compatible in your device","Weather-Service","Low","Trivial","Ramesh"));
				repo.save(new Issues(102,"Retrieval issue","Data can not be retrieved at the moment","Billing-Service","Medium","Minor","Rajesh"));
				repo.save(new Issues(103,"Server issue","Payment can not be done because of server issue with your bank","Payment-service","High","Major","Rakesh"));
				repo.save(new Issues(104,"Connection issue","Check your connection","Book-Service","Low","Trivial","Suresh"));
				repo.save(new Issues(105,"Verification issue","Verify yourself to proceed further","Ticket-Booking-service","high","Critical","Mahesh"));

				
			}
			
		};
	}
	
	
}
