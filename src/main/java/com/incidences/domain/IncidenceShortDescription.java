package com.incidences.domain;

import javax.persistence.Embeddable;

import com.shared.domain.StringValueObject;

@Embeddable
public class IncidenceShortDescription extends StringValueObject {

	
	String description;
	
	
	public IncidenceShortDescription() {}
	
	
	public IncidenceShortDescription(String description) {
		
		super.validator(description);
		this.value=description;
		this.description=description;
	}
	
	public String getDescriptionString() {
		return this.description;
	}
	
	@Override
	public boolean equals(StringValueObject other) {
		return ( other instanceof IncidenceShortDescription 
        		&& this.toString().equals(other.toString()));
	}
	
}
