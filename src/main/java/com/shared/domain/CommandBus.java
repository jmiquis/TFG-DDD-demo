package com.shared.domain;

public interface CommandBus {

	void dispatch(Command command);
	
}
