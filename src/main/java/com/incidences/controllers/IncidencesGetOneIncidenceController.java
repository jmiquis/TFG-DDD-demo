package com.incidences.controllers;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.incidences.application.find.FindIncidenceQuery;
import com.incidences.application.find.FoundIncidenceResponse;
import com.incidences.application.find.IncidenceFinder;
import com.shared.domain.QueryBus;

@RestController
public class IncidencesGetOneIncidenceController {

	QueryBus<IncidenceFinder> queryBus;

	
	public IncidencesGetOneIncidenceController(QueryBus<IncidenceFinder>  queryBus) {
		this.queryBus = queryBus;
	}
	
	@GetMapping(value="/incidences/{id}")
	public ResponseEntity<HashMap<String, String>>find (@PathVariable String id) {
		
		
		try {
			FindIncidenceQuery     query    = new FindIncidenceQuery(id);	
			FoundIncidenceResponse response = queryBus.ask(query);
			
			return ResponseEntity.ok().body(new HashMap<String,String>() {{
	            put("id", response.getIncidenceId());
	            put("created_by", response.getIncidenceCreator());
	            
	            if(response.asignees.size()!=0)put("asigned_to",new Gson().toJson(response.getAsignees()));
	            
	            put("created_on",response.getIncidenceCreatedOn());
	            put("description", response.getIncidenceDescription());
	        }});
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new HashMap<String,String>(){{
				put("exception_message",e.getMessage());
			}});
		}
		
		
		 
		
		
	}
	
}
