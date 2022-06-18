
package com.workers.domain;



import javax.persistence.Embeddable;

import com.shared.domain.Constants;
import com.shared.domain.StringValueObject;



@Embeddable
public class WorkerEmail extends StringValueObject{

	private static final long serialVersionUID = 1L;
	private String WorkerEmail;

	public WorkerEmail() {}
	
	public WorkerEmail(String proposedEmail) {
		
		//hay que checkear si el mail no esta repetido
		super.validator(proposedEmail);
		emailValidator(proposedEmail);
		this.value=proposedEmail;
		this.WorkerEmail=proposedEmail;
	}
	
	
	public static WorkerEmail changeEmail(String newEmail) {
		return new WorkerEmail(newEmail);
	}
	
	
	private void emailValidator(String proposedEmail) {
		
		int totalEmailLength       = proposedEmail.length();
		int companyDomainLength    = Constants.COMPANY_DOMAIN.length();
		String proposedEmailDomain = proposedEmail.substring((totalEmailLength-companyDomainLength),totalEmailLength);
		
		if (!proposedEmailDomain.equals(Constants.COMPANY_DOMAIN)) {
			throw new IllegalArgumentException("the email "+proposedEmail+(" is not a corporative valid one"));
		}
	}


	@Override
	public boolean equals(StringValueObject other) {
		return ( other instanceof WorkerEmail 
        		&& this.toString().equals(other.toString()));
	}
	

	public String getWorkerEmail() {
		return this.WorkerEmail;
	}
	
}