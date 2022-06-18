package com.incidences.infrasctructure;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.incidences.domain.Incidence;
import com.incidences.domain.Incidence.IncidenceAssignation;
import com.incidences.domain.IncidenceId;
import com.incidences.domain.IncidenceRepository;


@Repository
public class IncidenceRepositoryMysqlImplementation implements IncidenceRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
	@Override
	public void save(Incidence incidence) {
		entityManager.persist(incidence);
		entityManager.close();
	}

	@Override
	public Incidence searchById(IncidenceId id) throws IllegalArgumentException{
		
		Incidence incidence = entityManager.find(Incidence.class,id);
		
		if (incidence==null) throw new IllegalArgumentException("The Id "+id.getIncidenceId()+" doesn´t match any registered one");
		
		//este metodo levanta la tabla intermedia NxM en el caso de mysql
		incidence.loadAsignees(getAssigneeList(incidence.getId()));
		entityManager.close();
		return incidence;
	}

	@Override
	public ArrayList<IncidenceAssignation> getAssigneeList(IncidenceId incidenceId) {
		ArrayList<IncidenceAssignation>  asignees= new ArrayList<IncidenceAssignation>();
	
			asignees = (ArrayList<IncidenceAssignation>) entityManager.createNativeQuery("SELECT worker_id FROM incidence_assignation WHERE incidence_id LIKE ?")
			        .setParameter(1,incidenceId.getIncidenceId())
			        .getResultList();
			entityManager.close();
		
		return asignees;
	}

	@Override
	@Transactional
	public void update(Incidence incidence) {
		entityManager.merge(incidence);
	}

	@Transactional
	@Override
	public void addAsignee(IncidenceAssignation assignation) {
		 entityManager.persist(assignation);
	}

	@Override
	public ArrayList<String> allIncidencesId() {
		ArrayList<String>  allIncidencesId= new ArrayList<String>();
		
		allIncidencesId = (ArrayList<String>) entityManager.createNativeQuery("SELECT incidence_id FROM incidence")
		          	      .getResultList();
		entityManager.close();
		return allIncidencesId;
	}

	



}
