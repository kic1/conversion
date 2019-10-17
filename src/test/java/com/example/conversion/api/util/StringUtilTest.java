package com.example.conversion.api.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.apache.commons.lang3.RegExUtils;
import org.jsoup.Jsoup;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringUtilTest {
	
	private final String targetText   = "<!doctype html><html><head><script>alert('#');</script></head><body>Hi</body><html>";
	private final String expectedText = "alert('#');Hi";
	
	@Test
	public void t1_FAILED_escapeTagByJsoup() {
		
		String escapedText = Jsoup.parse(targetText).text();		
		assertNotSame("FAIL Jsoup", expectedText, escapedText);
	}
	
	@Test
	public void t2_FAILED_escapeTagByRegularExpression() {
		
		String escapedText = RegExUtils.replaceAll(targetText, "(<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>)", "");
		assertNotSame("FAIL general expression", expectedText, escapedText);
	}
	
	@Test
	public void t3_escapeTagByRegularExpression() {
		
		String escapedText = RegExUtils.replaceAll(targetText, "<.*?>", "");
		assertEquals(expectedText, escapedText);
	}
	
	@Test
	public void t4_escapeTag() {
		assertEquals(expectedText, StringUtil.escapeTag(targetText));
	}
}
