package com.shared.infrastructure;

import java.util.List;

import org.axonframework.eventhandling.GenericEventMessage;
import org.springframework.stereotype.Service;

import com.shared.domain.DomainEvent;
import com.shared.domain.EventBus;


@Service
public class BusAxonImplementation implements EventBus{

	private final org.axonframework.eventhandling.EventBus eventBus;
	
	public BusAxonImplementation(org.axonframework.eventhandling.EventBus eventBus) {
		this.eventBus=eventBus;
	}
	
	
	
	@Override
	public void publish(List<DomainEvent> events) {
		events.forEach(this::publish);
	}

	
	public void publish(final DomainEvent event) {
		this.eventBus.publish(GenericEventMessage.asEventMessage(event));
	}
}
