package com.example.conversion.util;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.RegExUtils;
import org.jsoup.Jsoup;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringUtilTest {
	
	/**
	 * Jsoup 으로 text 를 가져오는 것은 script 안의 alert 삭제 하므로 미사용
	 */
	@Test
	public void t1_escapeTagJsoup() {
		
		String source = "<html><head><script>alert('#');</script></head><body>Hi</body><html>";
		String textWithoutTag = Jsoup.parse(source).text();
		log.debug("t1_escapeTagJsoup : " + textWithoutTag);
		
		assertEquals("alert('#');Hi", textWithoutTag);
	}
	
	@Test
	public void t2_escapeTagRegularExpression() {
		
		String source = "<html><head><script>alert('#');</script></head><body>Hi</body><html>";
		String textWithoutTag = RegExUtils.replaceAll(source, "(<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>)", "");
	    
		log.debug("t2_escapeTagRegularExpression : " + textWithoutTag);
		
		assertEquals("alert('#');Hi", textWithoutTag);
	}
}
