package com.workers.domain;






import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.incidences.domain.Incidence.IncidenceAssignation;

@Service

public interface WorkerRepository {
    
	public void save(Worker worker);
	public Worker searchById(WorkerId id);
	public ArrayList<String> getAllWorkers();
	public ArrayList<IncidenceAssignation>allAssignedIncidencesByWorker(WorkerId id);
	
}
