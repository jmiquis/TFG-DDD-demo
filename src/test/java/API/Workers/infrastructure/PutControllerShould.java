package API.Workers.infrastructure;



import org.junit.jupiter.api.Test;

public class PutControllerShould extends RequestMoocTemplate {
		    
	    @Test
	    	    
	    void create_a_valid_non_existing_worker() throws Exception {
	        super.assertRequestWithBody(
	            "PUT",
	            "/workers/1aab45ba-3c7a-4344-8936-78466eca77fa",
	            "{\"worker_name\": \"pepe\", \"worker_email\": \"awdw@miempresa.com\",\"worker_phone\":\"444\"}",
	            201
	        );
	    }
		
	
}
