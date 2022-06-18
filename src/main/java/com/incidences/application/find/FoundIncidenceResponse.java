package com.incidences.application.find;

import java.util.List;

import com.incidences.domain.Incidence;
import com.incidences.domain.Incidence.IncidenceAssignation;
import com.shared.domain.Response;

import lombok.Getter;

@Getter
public class FoundIncidenceResponse implements Response {

	 String incidenceId;
	 String incidenceCreator;
	 String incidenceDescription;
	 String incidenceCreatedOn;
	 public List<IncidenceAssignation> asignees;
	
	public FoundIncidenceResponse(Incidence incidence) {
		this.incidenceId=incidence.getId().getIncidenceId();
		this.incidenceCreator=incidence.getCreator().getWorkerId();
		this.incidenceDescription=incidence.getDescription().getDescriptionString();
		this.asignees=incidence.getAsignees();
		this.incidenceCreatedOn=incidence.getCreatedOn().getProposedTimeStamp();
	}
}
