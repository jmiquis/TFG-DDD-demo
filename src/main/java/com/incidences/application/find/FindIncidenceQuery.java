package com.incidences.application.find;



import com.shared.domain.Query;

import lombok.Getter;

@Getter
public class FindIncidenceQuery implements Query {

	
	private String id;
	
	public FindIncidenceQuery (String id) {
		this.id=id;
	}

	@Override
	public String name() {
		return "find.incidence";
	}
	
}
