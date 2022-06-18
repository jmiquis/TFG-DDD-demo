package com.workers.application.find;

import java.util.Optional;

import com.workers.domain.Worker;

import lombok.Getter;

@Getter
public class FoundWorkerResponse {

	String workerId;
	String workerName;
	String workerEmail;
	String workerPhone;
	
	public FoundWorkerResponse(Worker worker) {
		
		this.workerId    = worker.idString();
		this.workerName  = worker.nameString();
		this.workerEmail = worker.emailString();
		this.workerPhone = worker.getTelExt();
		
	}
	
}
