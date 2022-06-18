package com.incidences.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.shared.domain.DomainUUiD;



@Embeddable
public class IncidenceId extends DomainUUiD implements Serializable{

private static final long serialVersionUID = 1L;
	
	
	public IncidenceId() {}
	
	public IncidenceId(String proposedId) {
		
		super(proposedId);
	}
	
	public static IncidenceId changeId(String newId) {
		return new IncidenceId(newId);
	}
	
	public boolean equals(IncidenceId other) {		
		return ( other instanceof IncidenceId 
        		&& this.toString().equals(other.toString()));	
	}

	
	public String getIncidenceId() {
		return this.value;
	}
	
}
