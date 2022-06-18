package com.workers.domain;


import java.io.Serializable;

import javax.persistence.Embeddable;

import com.shared.domain.StringValueObject;



@Embeddable
public final class WorkerCompleteName extends StringValueObject implements Serializable{

	
	
	private static final long serialVersionUID = 1L;
	private String workerCompleteName;
	
	public WorkerCompleteName() {}

	public WorkerCompleteName(String name) {
		super.validator(name);
		this.value=name;
		workerCompleteName=name;
		
	}
	
	
	public static WorkerCompleteName changeName (String newName) {
		return new WorkerCompleteName(newName);
	}


	@Override
	public boolean equals(StringValueObject other) {
		return ( other instanceof WorkerCompleteName 
        		&& this.toString().equals(other.toString()));
	}
	
	
	public String getWorkerCompleteName() {
		return this.workerCompleteName;
	}
	
}