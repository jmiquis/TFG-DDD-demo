package com.workers.controllers;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shared.domain.CommandBus;
import com.workers.application.create.CreateWorkerCommand;

import lombok.Getter;
import lombok.Setter;

@RestController
public class WorkerPutController {


	private CommandBus commandBus;
	
	public WorkerPutController(CommandBus commandBus) {
		this.commandBus=commandBus;
	}
	
	@PutMapping("/workers/{id}")
	public ResponseEntity<String> create(@PathVariable String id, @RequestBody PutWorkerRequest request) {
		
	
		CreateWorkerCommand command = new CreateWorkerCommand(id, request.getName(), request.getEmail(), request.getTelephone());
		commandBus.dispatch(command);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
}

//clase response dentro del mismo controller que recoge los datos externos 

@Setter
@Getter
final class PutWorkerRequest {
    private String name;
    private String email;
    private String telephone;
    
    
 
}