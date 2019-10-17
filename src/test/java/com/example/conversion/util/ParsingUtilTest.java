package com.example.conversion.util;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.conversion.api.util.StringUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParsingUtilTest {
	
	@Test
	public void t1_getHtmlByUrl() {

		String url = "https://okky.kr/article/639505";
		
		try {			
			Document doc = Jsoup.connect(url).get();
			String htmlFromUrl = doc.html();
			log.debug("t1_getHtmlByUrl : " + htmlFromUrl);
			
			assertNotNull(htmlFromUrl);
		} catch (IOException e) {
			log.error("checked exception");
		}
	}
	
	@Test
	public void t2_getHtmlByUrlAndEscapeTag() {

		String url = "https://okky.kr/article/639505";
		
		try {			
			Document doc = Jsoup.connect(url).get();
			String htmlFromUrl = doc.html();
			
			String textWithoutTag = StringUtil.escapeTag(htmlFromUrl);
			log.debug("t2_getHtmlByUrlAndEscapeTag : " + textWithoutTag);
			
			assertNotNull(textWithoutTag);
		} catch (IOException e) {
			
			log.error("checked exception");
		}
	}
}
