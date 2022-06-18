package com.workers.application.create;

import java.io.Serializable;
import java.util.HashMap;

import com.shared.domain.DomainEvent;


public class IncidenceWasCreated extends DomainEvent {
	
	private final String eventId;
	private final String creator;
	private final String description;
	private final String aggregateId;
	private final String ocurredOn;
	
	
	public IncidenceWasCreated(
			String creator,
			String description,
			String aggregateId,
			String ocurredOn
			) {
			this.creator     = creator;
			this.description = description;
			this.aggregateId = aggregateId;
			this.ocurredOn   = ocurredOn;
			this.eventId     = super.getUUiD();	
			}
	
	
	@Override
	public String eventName() {
		return "incidence.created";
	}

	@Override
	public HashMap<String, Serializable> toPrimitives() {
		return new HashMap<String, Serializable>() {{
            put("creator_id",creator ); 
            put("description",description);
        }};
	}

	@Override
	public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId,String occurredOn) {
	        return new IncidenceWasCreated(aggregateId,occurredOn,(String) body.get("incidence_id"),(String) body.get("description"));
	}
	
	public String creator() {return this.creator;}
	public String description(){return this.description; }
	
		
	
}
