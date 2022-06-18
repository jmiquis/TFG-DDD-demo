package com.incidences.domain;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Embeddable;

import com.shared.domain.StringValueObject;


@Embeddable
public class AssignationTimestamp extends StringValueObject {

	
private String ocurredOn;
	
	public AssignationTimestamp() {}
	
	public AssignationTimestamp(String proposedTimeStamp) {				
		super.validator(proposedTimeStamp);
		timeStampValidator(proposedTimeStamp);
		this.ocurredOn=proposedTimeStamp;
		
	}
	
	
	
	
	
	
	private void timeStampValidator(String proposedTimeStamp) {
		
		Timestamp actual = Timestamp.from(Instant.now());
		Timestamp timestamp = Timestamp.valueOf(proposedTimeStamp);
		
		if (timestamp.after(actual)) {
			throw new IllegalArgumentException("The timeStamp "+proposedTimeStamp+" cannot be later than the actual one");
		}
	}
	
	
	
	
	
	public String getProposedTimeStamp() {
		return this.ocurredOn;
	}

	

	@Override
	public boolean equals(StringValueObject other) {
		return ( other instanceof AssignationTimestamp 
        		&& this.toString().equals(other.toString()));
	}
}
