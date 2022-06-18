
  
package com.workers.infrastructure;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.incidences.domain.IncidenceId;
import com.incidences.domain.Incidence.IncidenceAssignation;
import com.workers.domain.Worker;
import com.workers.domain.WorkerId;
import com.workers.domain.WorkerRepository;


@Repository
public class WorkerRepositoryMysqlImplementation implements WorkerRepository {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public void save(Worker worker) {
		 entityManager.persist(worker);
		 entityManager.close();
	}


	@Override
	public Worker searchById(WorkerId id) {
		Worker found = entityManager.find(Worker.class, id);
		entityManager.close();
		return found;
	}
	
	@Override
	public ArrayList<String> getAllWorkers() {
		ArrayList<String> workerIds = (ArrayList<String>) entityManager.createNativeQuery("SELECT worker_id FROM worker")
			    .getResultList();
		entityManager.close();
			return workerIds;
		
	}


	@Override
	public ArrayList<IncidenceAssignation> allAssignedIncidencesByWorker(WorkerId id) {
		
		
			ArrayList<IncidenceAssignation>  asignedIncidences= new ArrayList<IncidenceAssignation>();
		
			asignedIncidences = (ArrayList<IncidenceAssignation>) entityManager.createNativeQuery("SELECT incidence_id FROM incidence_assignation WHERE worker_id LIKE ?")
				        .setParameter(1,id.getWorkerId())
				        .getResultList();
				entityManager.close();
			
			return asignedIncidences;
		}
	
}
	
	







	

	
	


	
	
	


	
	
	
	



