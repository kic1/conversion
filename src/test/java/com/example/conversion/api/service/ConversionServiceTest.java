package com.example.conversion.api.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.conversion.api.form.RequestForm;
import com.example.conversion.api.form.ResponseForm;
import com.example.conversion.engine.constants.ConversionConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConversionServiceTest {
	
	@Autowired ConversionContentService conversionContentService;
	
	@Test
	public void t01_getResult() throws Exception {
		
		RequestForm requestForm = RequestForm.builder()
				                             .targetUrl      (ConversionConstants.SAMPLE_PARSING_URL)
				                             .filterCondition(ConversionConstants.SAMPLE_FILTER_CONDITION)
				                             .splitUnitAmount(ConversionConstants.SAMPLE_SPLIT_UNIT_AMOUNT)
				                             .build();
		
		ResponseForm responseForm = conversionContentService.getResult(requestForm);
		assertNotNull(responseForm);
		
		boolean isExistQuotientText = StringUtils.isNotEmpty(responseForm.getQuotientText());
		boolean isExistRemainText   = StringUtils.isNotEmpty(responseForm.getRemainText());
		assertTrue(isExistQuotientText || isExistRemainText);
	}
}
