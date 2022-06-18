package com.incidences.application.notify;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import com.incidences.application.assign.IncidenceWasAssigned;
import com.shared.domain.NotificationDomainService;
import com.workers.domain.Worker;
import com.workers.domain.WorkerId;
import com.workers.domain.WorkerRepository;

@Service
public class AssignationNotifier {

	NotificationDomainService service;
	WorkerRepository repository;
	
	public AssignationNotifier(NotificationDomainService service,WorkerRepository repository) {
		this.service=service;
		this.repository=repository;
	}
	
	@EventHandler
	public void send(IncidenceWasAssigned event) {
		WorkerId id     = new WorkerId(event.getAssignee());
		Worker assignee = repository.searchById(id);
		
		if(assignee==null) throw new IllegalArgumentException("The worker Id "+event.getAssignee()+" doesn't match any of our resgistered workers");
		
		String toSend = "The incidence id "+event.getIncidenceId()+" : "+ " "+event.getDescription()+" has been attached to you at "+event.getOcurredOn();
		service.sendNotification(assignee.emailString(),"incidence number "+event.getIncidenceId(),toSend);
	}
	
}
