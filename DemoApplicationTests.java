package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.net.ssl.SSLEngineResult.Status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
//@ExtendWith(SpringRunner.class)
class DemoApplicationTests {
private MockMvc mockMvc;

@Autowired
WebApplicationContext context;

@BeforeEach
public void setup() {
	mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
}
	@Test
	void contextLoads() throws Exception {
		mockMvc.perform(get("/g")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.results.[0].title").exists())
	    .andExpect(MockMvcResultMatchers.jsonPath("$.section").exists());
	}

}
