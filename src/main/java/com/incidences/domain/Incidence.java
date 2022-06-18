package com.incidences.domain;


import java.util.ArrayList;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import com.incidences.application.assign.IncidenceWasAssigned;
import com.shared.domain.AggregateRoot;
import com.shared.domain.Constants;
import com.workers.application.create.IncidenceWasCreated;
import com.workers.domain.WorkerId;

@Entity(name="incidence")
@org.axonframework.modelling.command.AggregateRoot
public class Incidence extends AggregateRoot{
	
	
	@EmbeddedId
	@AttributeOverride(name="value", column=@Column(name="incidence_id"))
	@TargetAggregateIdentifier
	IncidenceId id;
	
	@Embedded
	@AttributeOverride(name="value", column=@Column(name="creator"))
	WorkerId creator;
	
	
	@Transient
	ArrayList <IncidenceAssignation> asignees;
		
	@Embedded 
	IncidenceCreationTimeStamp createdOn;
	
	@Embedded
	IncidenceShortDescription description;
	
	@Embedded
	IncidenceStatus status;
	

	private Incidence() {}
	
	private Incidence(
			IncidenceId id, 
			WorkerId creator, 
			IncidenceCreationTimeStamp createdOn,
			IncidenceShortDescription description) {
		this.id          = id;
		this.creator     = creator;
		this.createdOn   = createdOn;
		this.description = description;
		this.asignees    = new ArrayList<IncidenceAssignation>();
		this.status      = new IncidenceStatus("OPEN");
	}
	
	public static Incidence create(
			IncidenceId id, 
			WorkerId creator, 
			IncidenceCreationTimeStamp createdOn,
			IncidenceShortDescription description
			) 
	{	
		Incidence createdIncidence = new Incidence(id,creator,createdOn,description);
		IncidenceWasCreated createdDomainEvent = new IncidenceWasCreated(
		id.getIncidenceId()
		,creator.getWorkerId()
		,createdOn.getProposedTimeStamp()
		,description.getDescriptionString()
		);
		
		createdIncidence.record(createdDomainEvent);
		return createdIncidence;
	}
	
	
	public IncidenceAssignation assignIncidenceToWorker(WorkerId assignee) {
		IncidenceAssignation assignation = new IncidenceAssignation(this.id,assignee);
		this.addAsignee(assignation);
		IncidenceWasAssigned assignedIncidence = new IncidenceWasAssigned(id.getIncidenceId().toString(),assignee.getWorkerId(),description.description);
		this.record(assignedIncidence);
		return assignation;
	}
	
	
	
	
	public void addAsignee(IncidenceAssignation assignation) {
		asignees.add(assignation);
	}
	
	public void quitAsignee(IncidenceAssignation asignation) {
		asignees.remove(asignation);
	}
	
	public void changeDescription(String proposedDescription) {
		this.description=new IncidenceShortDescription(proposedDescription);
	}
	
	public void changeCreationTimeStamp(String proposedTimestamp) {
		this.createdOn= new IncidenceCreationTimeStamp(proposedTimestamp);
	}
	
	public void loadAsignees(ArrayList<IncidenceAssignation> loadedAsignees) {
		this.asignees=loadedAsignees;
	}
	public void changeStatus(String proposed) {
		this.status = new IncidenceStatus(proposed);
	}
	
	
	
	public IncidenceId getId() {
		return this.id;
	}
	public WorkerId getCreator() {
		return this.creator;
	}
	public IncidenceCreationTimeStamp getCreatedOn() {
		return this.createdOn;
	}
	public IncidenceShortDescription getDescription() {
		return this.description;
	}
	public ArrayList<IncidenceAssignation> getAsignees(){
		return this.asignees;
	}
	
	public IncidenceStatus getStatus() {
		return this.status;
	}
	
	
	@Entity(name="incidence_assignation")
	public class IncidenceAssignation{
		@EmbeddedId
		AssignationId id;
		
		@Embedded
		AssignationTimestamp ocurredOn;
		
		
		private IncidenceAssignation(IncidenceId incidenceId,WorkerId assignee) {
			this.id = new AssignationId(incidenceId,assignee);
			this.ocurredOn   = new AssignationTimestamp(Constants.TIMESTAMPS_FORMAT.format(new Date())); 
		}
		
		public IncidenceId getIncidenceId() {return this.id.incidenceId;}
		public WorkerId    getAssignee() {return this.id.assignee;}
	}

}

