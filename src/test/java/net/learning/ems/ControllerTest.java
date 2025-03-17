package net.learning.ems;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.learning.ems.controller.EmployeeController;
import net.learning.ems.dto.EmployeeDto;
import net.learning.ems.service.EmployeeService;
import net.learning.ems.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

@WebMvcTest(EmployeeController.class)
public class ControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    private EmployeeServiceImpl service;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testHelloEndpoint() throws Exception {

        List<EmployeeDto> resExpected = List.of(new EmployeeDto(), new EmployeeDto());
        when(service.getAllEmployees()).thenReturn(resExpected);

        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(resExpected)));

        /* For more details */
        /*String json = result.getResponse().getContentAsString();
        TypeToken<List<EmployeeDto>> typeToken = new TypeToken<>(){};
        List<EmployeeDto> articles = new Gson().fromJson(json, typeToken.getType());

        assertNotNull(articles);
        assertEquals(2, articles.size());*/
    }
}
