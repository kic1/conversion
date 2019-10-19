package com.example.conversion.api.service;

import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.conversion.engine.constants.ConversionConstants;
import com.example.conversion.engine.exception.GoneException;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParsingServiceTest {

	@Autowired ParsingContentService parsingService;
	
	@Test
	public void t01_getContents() {
		
		String contents = parsingService.getContents(ConversionConstants.PARSING_URL_SAMPLE);
		assertNotNull(contents);
	}
	
	@Test(expected = GoneException.class)
	public void t02_getContentsExpect_FAIL() {
		
		parsingService.getContents("http://INVAILD.URL");
	}
}
