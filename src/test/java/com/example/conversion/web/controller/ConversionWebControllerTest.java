package com.example.conversion.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConversionWebControllerTest {
	
	@Autowired
	public WebApplicationContext context;
	public static MockMvc mock;

	@Before
	public void setup() {
		mock = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void t01_existWebPage() throws Exception {
		mock.perform  (get("/conversion/form"))
		    .andDo    (print())
		    .andExpect(status().is(HttpStatus.OK.value()))
		    .andExpect(view().name(ConversionWebController.VIEW_CONVERSION_FORM_PAGE));
	}
}
