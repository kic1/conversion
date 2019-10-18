package com.example.conversion.engine.util;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import com.example.conversion.api.business.BusinessPattern;

public class FilterNumberUtil {
	
	public static String getOnlyNumber(String source) {
		return RegExUtils.replaceAll(source, BusinessPattern.DOES_NOT_CONTAIN_NUMBERS.getRegex(), StringUtils.EMPTY);
	}	
}
