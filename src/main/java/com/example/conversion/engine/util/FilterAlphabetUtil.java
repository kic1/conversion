package com.example.conversion.engine.util;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import com.example.conversion.api.business.BusinessPattern;

public class FilterAlphabetUtil {
	
	public static String getOnlyAlphabet(String source) {
		return RegExUtils.replaceAll(source, BusinessPattern.DOES_NOT_CONTAIN_ALPHABETS.getRegex(), StringUtils.EMPTY);
	}
}
