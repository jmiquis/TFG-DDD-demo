package API.Workers.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.workers.domain.WorkerPhoneExtension;

public class WorkerVOTest {

	
	@Test
	void workerVOShould() {
		
		WorkerPhoneExtension phoneJhon = new WorkerPhoneExtension("333");
		WorkerPhoneExtension phoneJoe  = new WorkerPhoneExtension("333");
		
		assertTrue(phoneJhon.equals(phoneJoe));
		
	}
	
}
