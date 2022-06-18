package com.workers.application.find;


import lombok.Getter;

@Getter
public class FindWorkerRequest {

	
	private String id;
	
	public FindWorkerRequest(String stringId) {
		
		this.id = stringId;
		
	}
}
