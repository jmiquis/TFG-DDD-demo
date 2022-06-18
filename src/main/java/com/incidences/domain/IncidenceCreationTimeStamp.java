package com.incidences.domain;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Embeddable;

import com.shared.domain.StringValueObject;

@Embeddable
public class IncidenceCreationTimeStamp extends StringValueObject{

	private String timeStamp;
	
	public IncidenceCreationTimeStamp() {}
	
	public IncidenceCreationTimeStamp(String proposedTimeStamp) {				
		super.validator(proposedTimeStamp);
		timeStampValidator(proposedTimeStamp);
		this.value=timeStamp;
		this.timeStamp=proposedTimeStamp;
		
	}
	
	
	
	
	
	
	private void timeStampValidator(String proposedTimeStamp) {
		
		Timestamp actual = Timestamp.from(Instant.now());
		Timestamp timestamp = Timestamp.valueOf(proposedTimeStamp);
		
		if (timestamp.after(actual)) {
			throw new IllegalArgumentException("The timeStamp "+proposedTimeStamp+" cannot be later than the actual one");
		}
	}
	
	
	
	
	
	public String getProposedTimeStamp() {
		return this.timeStamp;
	}

	

	@Override
	public boolean equals(StringValueObject other) {
		return ( other instanceof IncidenceCreationTimeStamp 
        		&& this.toString().equals(other.toString()));
	}

}
