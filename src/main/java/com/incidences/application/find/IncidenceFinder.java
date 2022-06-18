package com.incidences.application.find;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import com.incidences.domain.Incidence;
import com.incidences.domain.IncidenceId;
import com.incidences.domain.IncidenceRepository;
import com.shared.domain.QueryHandler;

@Service
public class IncidenceFinder implements QueryHandler<FindIncidenceQuery, FoundIncidenceResponse>{

	
	IncidenceRepository repository;
	
	public IncidenceFinder(IncidenceRepository repository) {
		this.repository=repository;
	}
	
	@Override
	@EventHandler
	public FoundIncidenceResponse handle (FindIncidenceQuery request) throws IllegalArgumentException{
		
		IncidenceId id      = new IncidenceId(request.getId());
		Incidence incidence = repository.searchById(id);
		
		return new FoundIncidenceResponse(incidence);
	}

	
}