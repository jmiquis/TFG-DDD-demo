package com.shared.infrastructure;

import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.shared.domain.Command;
import com.shared.domain.CommandBus;

@Service
public class CommandBusAxonImplementation implements CommandBus{

	
	private CommandGateway commandGateWay;
	
	public CommandBusAxonImplementation(CommandGateway commandGateWay) {
		this.commandGateWay=commandGateWay;
	}
	
	@Override
	public void dispatch(Command command) { 
		this.commandGateWay.sendAndWait(GenericCommandMessage.asCommandMessage(command));
	}
	
	
	
}
