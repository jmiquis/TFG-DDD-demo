package com.incidences.domain;

import java.util.ArrayList;

import javax.persistence.Embeddable;

import org.springframework.stereotype.Service;

import com.incidences.domain.Incidence.IncidenceAssignation;
import com.workers.domain.WorkerId;

@Embeddable
@Service
public interface IncidenceRepository {

	public void save(Incidence incidence);
	public Incidence searchById(IncidenceId id);
	public ArrayList <IncidenceAssignation> getAssigneeList(IncidenceId incidenceId);
	public void update(Incidence incidence);
	public void addAsignee(IncidenceAssignation assignation);
	public ArrayList<String>allIncidencesId();
	
}
