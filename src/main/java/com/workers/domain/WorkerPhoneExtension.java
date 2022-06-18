package com.workers.domain;

import javax.persistence.Embeddable;

import com.shared.domain.StringValueObject;



@Embeddable
public class WorkerPhoneExtension extends StringValueObject{
	
	
	private static final long serialVersionUID = 1L;
	private String workerPhoneExtension;
	
	public WorkerPhoneExtension() {}
	
	public WorkerPhoneExtension(String proposedPhoneExtension) {
		
		super.validator(proposedPhoneExtension);
		phoneExtensionValidator(proposedPhoneExtension);
		this.value=proposedPhoneExtension;
		this.workerPhoneExtension = proposedPhoneExtension;
		
	}
	
	public static WorkerPhoneExtension changePhoneExtension(String newPhoneExtension) {
		return new WorkerPhoneExtension(newPhoneExtension);
	}
	
	private void phoneExtensionValidator(String proposedPhoneExtension) {
		if(proposedPhoneExtension.length()!=3 
		   || !proposedPhoneExtension.chars().allMatch( Character::isDigit )) {
			throw new IllegalArgumentException("The phone extension "+proposedPhoneExtension+" is not a valid one");
		}
	}

	@Override
	public boolean equals(StringValueObject o) {
		return ( o instanceof WorkerPhoneExtension 
        		&& this.toString().equals(o.toString()));
	}

	public String getWorkerPhoneExtension() {
		return this.workerPhoneExtension;
	}
	
	

}
