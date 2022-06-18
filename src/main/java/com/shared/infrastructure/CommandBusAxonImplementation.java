package com.shared.infrastructure;

import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.shared.domain.Command;
import com.shared.domain.CommandBus;

@Service
public class CommandBusAxonImplementation implements CommandBus{

	private org.axonframework.commandhandling.CommandBus commandBus;
	private CommandGateway commandGateWay;
	
	public CommandBusAxonImplementation(org.axonframework.commandhandling.CommandBus commandBus,CommandGateway commandGateWay) {
		this.commandBus=commandBus;
		this.commandGateWay=commandGateWay;
	}
	
	@Override
	public void dispatch(Command command) { 
		this.commandGateWay.sendAndWait(GenericCommandMessage.asCommandMessage(command));
	}
	
	
	
}
