package com.cleanArchitecture.fq.infraestructure.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cleanArchitecture.fq.JsonDummies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {
	
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
    void testLogin_user_ok() throws Exception {
        String uriTest = "/login";
        this.mockMvc.perform(
                        post(uriTest).content(JsonDummies.getJsonUserDummyOk()).contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
	
	@Test
    void testLogin_user_Nok() throws Exception {
        String uriTest = "/login";
        this.mockMvc.perform(
                        post(uriTest).content(JsonDummies.getJsonUserDummyNOk()).contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound());
    }
	
	
	@Test
    void testLogin_empty() throws Exception {
        String uriTest = "/login";
        this.mockMvc.perform(
                        post(uriTest).content("").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isBadRequest());
    }
	

}
