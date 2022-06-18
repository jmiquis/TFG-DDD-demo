package com.workers.domain;


import java.util.ArrayList;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.axonframework.modelling.command.AggregateRoot;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.incidences.domain.Incidence.IncidenceAssignation;

import lombok.Getter;

@Getter
@Entity(name="worker")
@AggregateRoot
public class Worker{

	@EmbeddedId
	@AttributeOverride(name="value", column=@Column(name="worker_id"))
	@TargetAggregateIdentifier
	WorkerId               id;
	
	@Embedded
	WorkerCompleteName     name;
	
	@Embedded
	WorkerEmail            email;
	
	@Embedded
	WorkerPhoneExtension   phone;
	
	@Transient
	ArrayList<IncidenceAssignation>workerIncidenceAssignations;

	
	@Column(name="worker_total_tasks")
	int workerTotalTasks;
	
	public Worker() {}
	
	public Worker(
			WorkerId id,
			WorkerCompleteName name,
			WorkerEmail email,
			WorkerPhoneExtension phone
			) {
				this.id                 = id;
				this.name               = name;
				this.email              = email;
				this.phone              = phone;
				workerTotalTasks        = 0;
	}
	
	
	
	public WorkerId Id() {
		return id;
	}
	public WorkerCompleteName Name() {
		return name;
	}
	public WorkerEmail Email() {
		return email;
	}
	public WorkerPhoneExtension Extension() {
		return phone;
	}
	
	public String idString() {
		return this.id.getWorkerId();
	}
	public String nameString() {
		return this.name.getWorkerCompleteName();
	}
	public String emailString() {
		return this.email.getWorkerEmail();
	}
	public String getTelExt() {
		return this.phone.getWorkerPhoneExtension();
	}
	public int getTotalTasks() {
		return this.workerTotalTasks;
	}
	public void incrementNumberOfTasks() {
		this.workerTotalTasks++;
	}
	
	
	
	public void changeId(String proposedId) {
		this.id = WorkerId.changeId(proposedId);
	}
	
	public void changeName(String proposedName) {
		this.name = WorkerCompleteName.changeName(proposedName);
	}
	
	public void changeEmail(String proposedEmail) {
		this.email = WorkerEmail.changeEmail(proposedEmail);
	}
	
	public void changePhoneExtension(String proposedPhone) {
		this.phone = WorkerPhoneExtension.changePhoneExtension(proposedPhone);
	}
	
}