package com.workers.application.find;

import org.springframework.stereotype.Service;

import com.workers.domain.Worker;
import com.workers.domain.WorkerId;
import com.workers.domain.WorkerRepository;

@Service
public class WorkerFinder {
	
	private final WorkerRepository repository;

	
	public WorkerFinder(WorkerRepository repository) {
		this.repository = repository;
	}
	
	public FoundWorkerResponse find(FindWorkerRequest request) {
		WorkerId id = new WorkerId(request.getId()); 	
		
		Worker worker = repository.searchById(id);		
		
		if (worker==null) throw new IllegalArgumentException("The Id "+request.getId()+" doesn´t match any registered one");
		
		FoundWorkerResponse response = new FoundWorkerResponse(worker);
		return response;
		
	}
}
