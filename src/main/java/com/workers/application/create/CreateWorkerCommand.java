package com.workers.application.create;

import com.shared.domain.Command;

import lombok.Getter;


@Getter
public class CreateWorkerCommand implements Command {

		private final String id;
	    private final String name;
	    private final String email;
	    private final String telephone;
	    
	    public CreateWorkerCommand(String id, String name, String email, String phone) {
	    	this.id        = id;
	    	this.name      = name;
	    	this.email     = email;
	    	this.telephone = phone;
	    }
	 
	
}
