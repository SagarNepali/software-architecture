package service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.acme:evenoddService:+:stubs:8090")
public class MathControllerIntegrationTest {

	    @Autowired
	    private MockMvc mockMvc;

	    @Test
	    public void given_WhenPassEvenNumberInQueryParam_ThenReturnEven() throws Exception {
	        mockMvc.perform(MockMvcRequestBuilders.get("/calculate?number1=2&number2=2")
	          .contentType(MediaType.APPLICATION_JSON))
	          .andExpect(status().isOk())
	          .andExpect(content().string("Even"));
	    }

	    @Test
	    public void given_WhenPassOddNumberInQueryParam_ThenReturnOdd() throws Exception {
	        mockMvc.perform(MockMvcRequestBuilders.get("/calculate?number1=1&number2=2")
	          .contentType(MediaType.APPLICATION_JSON))
	          .andExpect(status().isOk())
	          .andExpect(content().string("Odd"));
	    }

	@Test
	public void given_WhenAdd2and5_ThenReturn7() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/add?number1=12&number2=15")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("27"));
	}

	@Test
	public void given_WhenDouble3_ThenReturn6() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/double?number=5")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("10"));
	}
}
