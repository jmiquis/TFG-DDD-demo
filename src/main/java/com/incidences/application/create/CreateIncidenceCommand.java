package com.incidences.application.create;

import com.shared.domain.Command;

import lombok.Getter;

@Getter
public class CreateIncidenceCommand implements Command {

	
	private final String id;
	private final String description;
	private final String creator;
	
	public CreateIncidenceCommand(String id,String creator, String description) {
		this.id          = id;
		this.creator     = creator;
		this.description = description;
	}
}
