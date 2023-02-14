package it.epicode.be.prenotazioni;



import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class EndpointTest {
	
	@Autowired
	private MockMvc e;
	
	@Test
	public void trueEndpoint() throws UnsupportedEncodingException, Exception {
		assertTrue(
		e.perform(
				MockMvcRequestBuilders.get("/api/istruzioni/it")
				)
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andReturn()
			.getResponse()
			.getContentAsString()
			.contains("benvenuto")
		);
		
		
		
			
	}

	
	

}
