package com.example.conversion.api.service;

import java.math.BigInteger;

import org.jsoup.internal.StringUtil;
import org.springframework.stereotype.Service;

import com.example.conversion.api.business.MergeText;
import com.example.conversion.api.business.FilterCondition;
import com.example.conversion.api.business.SplitText;
import com.example.conversion.api.form.RequestForm;
import com.example.conversion.api.form.ResponseForm;
import com.example.conversion.engine.util.ComparatorAlphabet;
import com.example.conversion.engine.util.ComparatorNumber;
import com.example.conversion.engine.util.FilterAlphabetUtil;
import com.example.conversion.engine.util.FilterHtmlUtil;
import com.example.conversion.engine.util.FilterNumberUtil;
import com.example.conversion.engine.util.SortStringUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ConversionContentService {
	
	private final ParsingContentService parsingContentService;
	
	public ResponseForm getResult(RequestForm requestForm) {
		
		log.debug("*** requestForm : " + requestForm);
		
		String url = requestForm.getUrl();
		String filterCondition = requestForm.getFilterCondition();
		BigInteger splitUnitAmount = requestForm.getSplitUnitAmount();

		String parseText  = parse(url);
		String escapeText = escapeTag(parseText, filterCondition);
		String mergedText = sortAndCombinateByCharacter(escapeText);
		
		return ResponseForm.builder()
		                   .quotientText(SplitText.getQuotientText(mergedText, splitUnitAmount))
		                   .remainText  (SplitText.getRemainText  (mergedText, splitUnitAmount))
		                   .build();
	}
	
	private String parse(String url) {
		return parsingContentService.getContents(url);
	}
	
	private String escapeTag(String parseText, String filterCondition) {
		
		
		String result = parseText;
		if(FilterCondition.ONLY_TEXT.name().equals(filterCondition)) {
			log.debug("*** escapeTag");
			result = FilterHtmlUtil.escapeTag(parseText);
		}
		return result;
	}
	
	private String sortAndCombinateByCharacter(String source) {
		
		String onlyAlphabetText = FilterAlphabetUtil.getOnlyAlphabet(source);
		String onlyNumberText   = FilterNumberUtil.getOnlyNumber(source);
		
		String alphabeticalText = SortStringUtil.getOrderedText(onlyAlphabetText, new ComparatorAlphabet());
		String nummericalText   = SortStringUtil.getOrderedText(onlyNumberText,   new ComparatorNumber());
		
		return MergeText.mergeText(alphabeticalText, nummericalText);
	}
}
