package net.learning.ems;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmsApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void testEndpoint() throws Exception {
		System.out.println("in testEndpoint");
	}
}
