package com.example.conversion.api.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.example.conversion.api.form.RequestForm;
import com.example.conversion.api.form.ResponseForm;
import com.example.conversion.api.service.ConversionContentService;
import com.example.conversion.engine.constants.ConversionConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConversionContentControllerTest {
	
	@Autowired
	public WebApplicationContext context;
	public static MockMvc mock;
	MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
	private RequestForm requestForm = RequestForm.builder()
                                                 .targetUrl      (ConversionConstants.SAMPLE_PARSING_URL)
                                                 .filterCondition(ConversionConstants.SAMPLE_FILTER_CONDITION)
                                                 .splitUnitAmount(ConversionConstants.SAMPLE_SPLIT_UNIT_AMOUNT)
                                                 .build();
	
	@Mock
	private ConversionContentService conversionContentService;

	@Before
	public void setup() {
		mock = MockMvcBuilders.webAppContextSetup(context).build();
		
		multiValueMap.add("targetUrl",       ConversionConstants.SAMPLE_PARSING_URL);
		multiValueMap.add("filterCondition", ConversionConstants.SAMPLE_FILTER_CONDITION_STRING);
		multiValueMap.add("splitUnitAmount", ConversionConstants.SAMPLE_SPLIT_UNIT_AMOUNT_STRING);
	}
	
	@Test
	public void t01_workingController() throws Exception {
		givenConversionContentService();
		ResponseForm responseForm = conversionContentService.getResult(requestForm);

		assertEquals(ConversionConstants.SAMPLE_EXPECTED_QUOTIENT_TEXT, responseForm.getQuotientText());
		assertEquals(ConversionConstants.SAMPLE_EXPECTED_REMAIN_TEXT,   responseForm.getRemainText());
	}
	
	private void givenConversionContentService() {
		
		ResponseForm mockReponseForm = ResponseForm.builder()
				                                   .quotientText(ConversionConstants.SAMPLE_EXPECTED_QUOTIENT_TEXT)
				                                   .remainText(ConversionConstants.SAMPLE_EXPECTED_REMAIN_TEXT)
				                                   .build();
		when(conversionContentService.getResult(requestForm)).thenReturn(mockReponseForm);
	}
	
	@Test
	public void t02_workingConversionAPI() throws Exception {
		mock.perform  (get("/api/conversion").params(multiValueMap))
		    .andDo    (print())
		    .andExpect(status().is(HttpStatus.OK.value()))
		    .andExpect(content().contentType("application/json;charset=utf-8"));
	}
}
