package com.example.conversion.engine.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.conversion.engine.util.FilterHtmlUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FilterHtmlUtilTest {
	
	private final String targetText   = "<!doctype html><html><head><script>alert('#');</script></head><body>Hi</body><html>";
	private final String expectedText = "alert('#');Hi";
	
	@Test
	public void t01_FAILED_escapeTagByJsoup() {
		
		String escapedText = Jsoup.parse(targetText).text();		
		assertNotSame("FAIL Jsoup", expectedText, escapedText);
	}
	
	@Test
	public void t02_FAILED_escapeTagByRegularExpression() {
		
		String escapedText = RegExUtils.replaceAll(targetText, "(<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>)", StringUtils.EMPTY);
		assertNotSame("FAIL general expression", expectedText, escapedText);
	}
	
	@Test
	public void t03_escapeTagByRegularExpression() {
		
		String escapedText = RegExUtils.replaceAll(targetText, "<.*?>", StringUtils.EMPTY);
		assertEquals(expectedText, escapedText);
	}
	
	@Test
	public void t04_escapeTag() {
		assertEquals(expectedText, FilterHtmlUtil.escapeTag(targetText));
	}
}
