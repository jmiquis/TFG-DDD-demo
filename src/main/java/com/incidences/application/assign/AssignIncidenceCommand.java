package com.incidences.application.assign;

import com.shared.domain.Command;

import lombok.Getter;

@Getter
public class AssignIncidenceCommand implements Command {

	private final String incidenceId;
	private final String assignee;
	
	
	public AssignIncidenceCommand(String incidenceId, String assignee) {
		this.incidenceId = incidenceId;
		this.assignee    = assignee;
	}
	
}
