package com.shared.infrastructure;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.springframework.stereotype.Service;

import com.shared.domain.Query;
import com.shared.domain.QueryBus;
import com.shared.domain.QueryHandler;
import com.shared.domain.Response;

@Service
public class QueryBusImplementation <T extends QueryHandler>implements QueryBus {

	private EventBus queryBus;
	private T handler;
	
	public QueryBusImplementation(EventBus queryBus,T handler) {
		this.queryBus = queryBus;
		this.handler  = handler;
	}
	
	public Response ask(Query query) {
		this.queryBus.publish(GenericEventMessage.asEventMessage(query));
		return this.handler.handle(query);
	}
	
}
