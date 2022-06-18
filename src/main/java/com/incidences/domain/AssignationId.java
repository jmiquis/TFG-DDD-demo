package com.incidences.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.shared.domain.StringValueObject;
import com.workers.domain.WorkerId;

@Embeddable
public class AssignationId extends StringValueObject{
	private static final long serialVersionUID = 1L;
	@AttributeOverride(name="value", column=@Column(name="worker_id"))
	WorkerId assignee;
	@AttributeOverride(name="value", column=@Column(name="incidence_id"))
	IncidenceId incidenceId;
	
	public AssignationId(IncidenceId incidenceId, WorkerId assignee) {
		this.assignee    = assignee;
		this.incidenceId = incidenceId;
	}

	@Override
	public boolean equals(StringValueObject other) {
		return (other instanceof AssignationId && this.assignee.toString().equals(other.toString()) && this.incidenceId.toString().equals(other.toString())); 
	}
}
