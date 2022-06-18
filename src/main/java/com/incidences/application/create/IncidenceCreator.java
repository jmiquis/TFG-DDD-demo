package com.incidences.application.create;

import java.util.Date;
import java.util.List;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Service;

import com.incidences.domain.Incidence;
import com.incidences.domain.IncidenceCreationTimeStamp;
import com.incidences.domain.IncidenceId;
import com.incidences.domain.IncidenceRepository;
import com.incidences.domain.IncidenceShortDescription;
import com.shared.domain.EventBus;
import com.shared.domain.Constants;
import com.workers.domain.WorkerId;
import com.workers.domain.WorkerRepository;

@Service
public class IncidenceCreator {

	private final EventBus eventBus;
	private final WorkerRepository wokerRepo;
	private final IncidenceRepository incideceRepo;
	
	public IncidenceCreator(EventBus eventBus,WorkerRepository wokerRepo,IncidenceRepository incideceRepo) {
		this.eventBus=eventBus;
		this.wokerRepo=wokerRepo;
		this.incideceRepo=incideceRepo;
	}
	

	
	@CommandHandler
	public void createIncidence (CreateIncidenceCommand command) {
		
		List<String> allWorkers   = wokerRepo.getAllWorkers();
		if(!allWorkers.contains(command.getCreator()))
			throw new IllegalArgumentException("The id "+command.getCreator()+" doesn't match with any of our registered workers");
		
		final IncidenceId id                        = new IncidenceId(command.getId());
		final WorkerId creator                      = new WorkerId(command.getCreator());
		final IncidenceCreationTimeStamp createdOn  = new IncidenceCreationTimeStamp(Constants.TIMESTAMPS_FORMAT.format(new Date()));;
		final IncidenceShortDescription description = new IncidenceShortDescription(command.getDescription());
		
		final Incidence incidence = Incidence.create(id,creator,createdOn,description);
		incideceRepo.save(incidence);
		eventBus.publish(incidence.pullDomainEvents());
		
	}
	
	
}
