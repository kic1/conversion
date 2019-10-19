package com.example.conversion.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.example.conversion.api.business.FilterCondition;
import com.example.conversion.engine.constants.ConversionConstants;
import com.example.conversion.web.controller.ConversionWebController;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConversionControllerTest {
	
	@Autowired
	public WebApplicationContext context;
	public static MockMvc mock;
	public static MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();

	@Before
	public void setup() {
		mock = MockMvcBuilders.webAppContextSetup(context).build();
		 
		multiValueMap.add("targetUrl",       ConversionConstants.PARSING_URL_SAMPLE);
		multiValueMap.add("filterCondition", FilterCondition.EXCLUDE_HTML_TAG.toString());
		multiValueMap.add("splitUnitAmount", "5");
	}
	
	@Test
	public void t01_existWebPage() throws Exception {
		mock.perform  (get("/conversion/form"))
		    .andDo    (print())
		    .andExpect(status().is(HttpStatus.OK.value()))
		    .andExpect(view().name(ConversionWebController.VIEW_CONVERSION_FORM_PAGE));
	}
	
	@Test
	public void t02_workingConversionAPI() throws Exception {
		mock.perform  (get("/api/conversion").params(multiValueMap))
		    .andDo    (print())
		    .andExpect(status().is(HttpStatus.OK.value()))
		    .andExpect(content().contentType("application/json;charset=utf-8"));
	}
}
