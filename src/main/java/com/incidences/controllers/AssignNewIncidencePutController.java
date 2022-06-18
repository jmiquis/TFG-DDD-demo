package com.incidences.controllers;

import java.util.HashMap;
import java.util.Optional;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.incidences.application.assign.AssignIncidenceCommand;
import com.incidences.application.assign.IncidenceWasAssigned;
import com.shared.domain.CommandBus;

import lombok.Getter;
import lombok.Setter;


@RestController
public class AssignNewIncidencePutController {

	
	CommandBus commandBus;
	
	public AssignNewIncidencePutController(CommandBus commandBus) {
		this.commandBus=commandBus;
	}
	
	@PutMapping("/assign-incidences/{id}")
	public ResponseEntity<HashMap<String, String>> assign(@PathVariable String id, @RequestBody HttpAssignRequest request) {
		
		try {
			AssignIncidenceCommand command = new AssignIncidenceCommand(id, request.getWorkerId());
			commandBus.dispatch(command);
		
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new HashMap<String,String>(){{
				put("exception_message",e.getMessage());
			}});
		}
		return ResponseEntity.ok().body(new HashMap<String,String>(){{	
			put("assigned_to_worker",request.getWorkerId());
			put("incidence",id);
		}});
	}
	
}


@Getter
@Setter
final class HttpAssignRequest{
	private String workerId;
}
