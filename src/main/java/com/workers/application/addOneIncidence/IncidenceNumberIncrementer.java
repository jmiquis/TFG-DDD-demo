package com.workers.application.addOneIncidence;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import com.incidences.application.assign.IncidenceWasAssigned;
import com.workers.domain.Worker;
import com.workers.domain.WorkerId;
import com.workers.domain.WorkerRepository;

@Service
public class IncidenceNumberIncrementer {
	
	WorkerRepository repository;
	
	public IncidenceNumberIncrementer(WorkerRepository repository) {
		this.repository=repository;
	}
	
	
	@EventHandler
	private void increment(IncidenceWasAssigned event) {
		
		WorkerId id   = new WorkerId(event.getAssignee());
		Worker worker = repository.searchById(id);
		
		if(worker==null) throw new IllegalArgumentException("invalid worker Id");
		
		worker.incrementNumberOfTasks();	
		repository.save(worker);
	}
	
}
