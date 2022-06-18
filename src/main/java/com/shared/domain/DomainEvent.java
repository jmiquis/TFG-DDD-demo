package com.shared.domain;

import java.io.Serializable;

import java.util.HashMap;
import java.util.UUID;


//clase adaptada de https://github.com/CodelyTV/java-ddd-skeleton/


public abstract class DomainEvent{
	
    private String aggregateId;
    private String eventId;
    private String occurredOn;
    
   

    protected DomainEvent() {}

    public abstract String eventName();

    public abstract HashMap<String, Serializable> toPrimitives();

    public abstract DomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    );

    public String aggregateId() {
        return aggregateId;
    }

    public String eventId() {
        return eventId;
    }

    public String occurredOn() {
        return occurredOn;
    }
    public String getUUiD() {
    	return UUID.randomUUID().toString();
    }
    
}