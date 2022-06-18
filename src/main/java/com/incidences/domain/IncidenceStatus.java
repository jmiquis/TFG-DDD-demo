package com.incidences.domain;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Transient;

import com.shared.domain.StringValueObject;

public class IncidenceStatus extends StringValueObject{

	private static final long serialVersionUID = 1L;

	@Transient
	private final String[] STATUS_LIST ={"OPEN","ASSIGNED","CLOSED"};
	
	private String status;
	
	
	public IncidenceStatus() {}
	
	public IncidenceStatus(String proposedStatus) {
		
		super.validator(proposedStatus);
		statusValidator(proposedStatus);
		this.status=proposedStatus;
	}
	
	
	
	
	public void statusValidator(String proposed) {
		
		String proposedToUpper  = proposed.toUpperCase();
		List<String> statusList = Arrays.asList(STATUS_LIST);
		
		if(!statusList.contains(proposedToUpper)) {
			throw new IllegalArgumentException("The incidence status "+proposed+" is not a valid one");
		}
	}
	
	@Override
	public String toString() {
		return this.status;
	}
	
	@Override
	public boolean equals(StringValueObject other) {
		return other instanceof IncidenceStatus &&
				this.toString().equals(other.toString());
	}

}
