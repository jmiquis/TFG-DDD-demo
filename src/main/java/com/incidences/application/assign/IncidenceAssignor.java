package com.incidences.application.assign;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidences.domain.Incidence;
import com.incidences.domain.Incidence.IncidenceAssignation;
import com.incidences.domain.IncidenceId;
import com.incidences.domain.IncidenceRepository;
import com.shared.domain.EventBus;
import com.workers.domain.WorkerId;
import com.workers.domain.WorkerRepository;


@Service
public class IncidenceAssignor {
	
	IncidenceRepository incidenceRepository;
	WorkerRepository workerReporsitory;
	EventBus eventBus;
	
	public IncidenceAssignor(
			IncidenceRepository incidenceRepository,
			EventBus eventBus,
			WorkerRepository workerReporsitory
	) {
		this.incidenceRepository = incidenceRepository;
		this.eventBus            = eventBus;
		this.workerReporsitory   = workerReporsitory;
	}
	
	
	@CommandHandler
	@Transactional
	public void assign(AssignIncidenceCommand command) {
		WorkerId assignee       = new WorkerId(command.getAssignee());	
		
		if(!workerReporsitory.getAllWorkers().contains(assignee.getWorkerId())) 
			throw new IllegalArgumentException("This id doesn't match any registered worker id");
		
		IncidenceId incidenceId          = new IncidenceId (command.getIncidenceId());
		Incidence incidence              = incidenceRepository.searchById(incidenceId);
		
		
		if(!incidenceRepository.allIncidencesId().contains(incidenceId.getIncidenceId())) 
			throw new IllegalArgumentException("This id doesn't match any registered incidence id");		
		
		IncidenceAssignation assignation = incidence.assignIncidenceToWorker(assignee);
		
		incidence.changeStatus("ASSIGNED");
		incidenceRepository.addAsignee(assignation);
		eventBus.publish(incidence.pullDomainEvents());
		
	}
	
}
