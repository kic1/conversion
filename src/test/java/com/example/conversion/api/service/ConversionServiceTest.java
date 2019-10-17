package com.example.conversion.api.service;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.conversion.api.util.StringUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConversionServiceTest {
	
	final static String url = "https://okky.kr/article/639505";
	static String htmlFromUrl = "";
	
	@BeforeClass
	public static void getHtmlByUrl() throws IOException {
		htmlFromUrl = parsingService.getHtmlByUrl(url);
		log.debug(htmlFromUrl);
	}

	/**
	 * 1. 모든문자 입력 (입력항목 : url 기준 파싱된 html | 중국어, 일본어 등이 들어 갈 수 있다.)
	 */
	@Test
	public void t1_getHtmlByUrl() {
		assertNotNull(htmlFromUrl);
	}
	
	@Test
	public void t2_getHtmlByUrlAndEscapeTag() {
		
		String escapedTagText = StringUtil.escapeTag(htmlFromUrl);
		assertNotNull(escapedTagText);
	}
	
	/**
	 * 2. 영어, 숫자만 출력
	 * 3. 오름차순 (정렬) 
	 *   * 영어 : AaBb...Zz 
	 *   * 숫자 : 012... 
	 * 4. 교차출력 
	 *   * 영어 숫자 영어 ...
	 * 5. 출력묶음단위 (기준으로 묶이는 부분이 몫, 묶이지 않는 부분이 나머지)
	 */
	@Autowired static ParsingService parsingService;

}
