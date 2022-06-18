package com.incidences.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.incidences.application.create.CreateIncidenceCommand;
import com.shared.domain.CommandBus;

import lombok.Getter;
import lombok.Setter;

@RestController
public class IncidencesPutController {

	CommandBus commandBus;
	
	public IncidencesPutController(CommandBus commandBus) {
		this.commandBus=commandBus;
	}
	
	@PutMapping("/incidences/{id}")
	public ResponseEntity<String> create(@PathVariable String id, @RequestBody PutIncidenceRequest request) {
		
		
		
		CreateIncidenceCommand newIncidenceCommand = new CreateIncidenceCommand(id, request.getCreator(),request.getDescription());
		commandBus.dispatch(newIncidenceCommand);	
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	
}



@Setter
@Getter
final class PutIncidenceRequest {
    private String creator;
    private String description;
    
    
 
}