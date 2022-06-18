package API.Workers.infrastructure;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class RequestMoocTemplate {
	

	    @Autowired
	    private MockMvc  mockMvc;
	    
	   protected void assertRequestWithBody(
		        String method,
		        String endpoint,
		        String body,
		        int expectedStatusCode
		    ) throws Exception {
			this.mockMvc
		            .perform(request(HttpMethod.valueOf(method), endpoint).content(body).contentType(APPLICATION_JSON))
		            .andExpect(status().is(expectedStatusCode))
		            .andExpect((ResultMatcher) content().string(""));
		    }
	}

