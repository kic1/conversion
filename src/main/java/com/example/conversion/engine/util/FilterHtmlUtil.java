package com.example.conversion.engine.util;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import com.example.conversion.api.business.BusinessPattern;

public class FilterHtmlUtil {
	
	public static String escapeTag(String source) {
		return RegExUtils.replaceAll(source, BusinessPattern.HTML_TAG.getRegex(), StringUtils.EMPTY);
	}
}
