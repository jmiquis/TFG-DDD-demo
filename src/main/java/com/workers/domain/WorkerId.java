package com.workers.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.shared.domain.DomainUUiD;



@Embeddable
public class WorkerId extends DomainUUiD implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	public WorkerId() {}
	
	public WorkerId(String proposedId) {

		super(proposedId);
	}
	
	public static WorkerId changeId(String newId) {
		return new WorkerId(newId);
	}
	

	public boolean equals(WorkerId other) {		
		return ( other instanceof WorkerId 
        		&& this.toString().equals(other.toString()));	
	}

	@Override
	public String toString() {
		return this.value;
	}
	
	public String getWorkerId() {
		return this.value;
	}
	
}