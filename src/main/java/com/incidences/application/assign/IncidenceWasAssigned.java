package com.incidences.application.assign;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.shared.domain.Constants;
import com.shared.domain.DomainEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter

public class IncidenceWasAssigned extends DomainEvent {

	@TargetAggregateIdentifier
	private final String incidenceId;
	private final String ocurredOn;
	private final String assignee;
	private final String eventId;
	private final String description;
	
	public IncidenceWasAssigned(
			String incidenceId,
			String assignee,
			String description
			) {
		this.incidenceId = incidenceId;
		this.assignee    = assignee;
		this.ocurredOn   = Constants.TIMESTAMPS_FORMAT.format(new Date());
		this.eventId     = super.getUUiD();	
		this.description = description;
	}



	@Override
	public String eventName() {
		return "incidence.assigned";
	}



	@Override
	public HashMap<String, Serializable> toPrimitives() {
		return new HashMap<String,Serializable>(){{
			put("incidence_id",incidenceId);
			put("assignee",assignee);
			put("ocurred_on",ocurredOn);
		}};
	}



	@Override
	public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId,String occurredOn) {
		return new IncidenceWasAssigned(aggregateId,ocurredOn,(String)body.get(assignee),(String)body.get(description),eventId);
	}
}
