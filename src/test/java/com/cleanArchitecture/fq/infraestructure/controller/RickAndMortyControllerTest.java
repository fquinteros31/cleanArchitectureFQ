package com.cleanArchitecture.fq.infraestructure.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;


@SpringBootTest
@Profile("test")
@AutoConfigureMockMvc
class RickAndMortyControllerTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
    void getCharacter_ok() throws Exception {
        String uriTest = "/api/RickAndMorty/v1/getCharacter/1";
        this.mockMvc.perform(get(uriTest)).andDo(print()).andExpect(status().isOk());
    }
	
	@Test
    void getCharacter_zero() throws Exception {
        String uriTest = "/api/RickAndMorty/v1/getCharacter/0";
        assertThrows(NestedServletException.class, () -> this.mockMvc.perform(get(uriTest)));
    }
	
	
	@Test
    void getCharacter_not_found() throws Exception {
        String uriTest = "/api/RickAndMorty/v1/getCharacter/9000000";
        this.mockMvc.perform(get(uriTest)).andDo(print()).andExpect(status().isNotFound());
    }
	
	@Test
    void getCharacter_bad_request() throws Exception {
        String uriTest = "/api/RickAndMorty/v1/getCharacter/99999999999999";
        this.mockMvc.perform(get(uriTest)).andDo(print()).andExpect(status().isBadRequest());
    }

}
