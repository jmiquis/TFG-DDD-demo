package API.Workers.domain;

import org.junit.jupiter.api.Test;

import com.workers.domain.Worker;
import com.workers.domain.WorkerCompleteName;
import com.workers.domain.WorkerEmail;
import com.workers.domain.WorkerId;
import com.workers.domain.WorkerPhoneExtension;
import com.workers.infrastructure.WorkerRepositoryMysqlImplementation;
public class MysqlImplementationWorkerRepositoryShould{
	

	WorkerRepositoryMysqlImplementation repository=new WorkerRepositoryMysqlImplementation() ;
	
	
	@Test
    void save_a_course() {
        WorkerId workerId=new WorkerId("123e4567-e89b-12d3-a456-426614174000");
        WorkerCompleteName name = new WorkerCompleteName("Pedro Perez");
        WorkerEmail email = new WorkerEmail("pperez@miempresa.com");
        WorkerPhoneExtension phone = new WorkerPhoneExtension("444");
        repository.save(new Worker(
        		workerId,
        		name,
        		email,
        		phone));
    }

	
	
}
