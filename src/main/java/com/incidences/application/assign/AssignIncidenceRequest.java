package com.incidences.application.assign;




import lombok.Getter;

@Getter
public class AssignIncidenceRequest{
	
	private final String incidenceId;
	private final String workerId;
	
	public AssignIncidenceRequest(String incidenceId, String workerId) {
		this.incidenceId=incidenceId;
		this.workerId=workerId;
	}
	
}
