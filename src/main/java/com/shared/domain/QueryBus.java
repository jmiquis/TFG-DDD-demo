package com.shared.domain;

import org.springframework.stereotype.Service;

@Service
public interface QueryBus <T extends QueryHandler> {
	public <R extends Response>R ask(Query query);
}
