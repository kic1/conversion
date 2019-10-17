package com.example.conversion.api.service;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.conversion.api.service.ParsingService;
import com.example.conversion.api.util.StringUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParsingServiceTest {
	
	final String url = "https://okky.kr/article/639505";
	
	@Test
	public void t1_getHtmlByUrl() throws IOException {
		
		String htmlFromUrl = parsingService.getHtmlByUrl(url);
		assertNotNull(htmlFromUrl);
	}
	
	@Test
	public void t2_getHtmlByUrlAndEscapeTag() throws IOException {
		
		String escapedTagText = StringUtil.escapeTag(parsingService.getHtmlByUrl(url));
		assertNotNull(escapedTagText);
	}
	@Autowired ParsingService parsingService;
}
