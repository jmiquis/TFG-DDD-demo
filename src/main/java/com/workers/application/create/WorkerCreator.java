package com.workers.application.create;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Service;

import com.workers.domain.Worker;
import com.workers.domain.WorkerCompleteName;
import com.workers.domain.WorkerEmail;
import com.workers.domain.WorkerId;
import com.workers.domain.WorkerPhoneExtension;
import com.workers.domain.WorkerRepository;


@Service
public class WorkerCreator {

	private final WorkerRepository repository;
	
	public WorkerCreator (WorkerRepository repository) {
		this.repository=repository;
	}
	
	@CommandHandler
	public void create(CreateWorkerCommand command ) {
		WorkerId id                = new WorkerId(command.getId());
		WorkerCompleteName name    = new WorkerCompleteName(command.getName());
		WorkerEmail email          = new WorkerEmail(command.getEmail());
		WorkerPhoneExtension phone = new WorkerPhoneExtension(command.getTelephone());
		Worker worker              = new Worker(id ,name, email, phone);
		repository.save(worker);
	
	}
	
}