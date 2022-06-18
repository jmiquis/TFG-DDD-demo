package com.workers.controllers;


import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.workers.application.find.FindWorkerRequest;
import com.workers.application.find.FoundWorkerResponse;
import com.workers.application.find.WorkerFinder;


@RestController
public class WorkerGetOneController {

	
private WorkerFinder finder;
	
	public WorkerGetOneController(WorkerFinder finder) {
		this.finder=finder;
	}
	
	@GetMapping(value="/workers/{id}")
	public ResponseEntity<HashMap<String, String>>find (@PathVariable String id) {
		FindWorkerRequest findWorkerRequest = new FindWorkerRequest(id);
		FoundWorkerResponse response = finder.find(findWorkerRequest); 
		
		
		
		 return ResponseEntity.ok().body(new HashMap<String, String>() {{
	            put("id", response.getWorkerId());
	            put("name", response.getWorkerName());
	            put("email", response.getWorkerEmail());
	            put("tel_ext", response.getWorkerPhone());
	        }});
		
		
	}
	
	
}
