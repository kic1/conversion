package com.example.conversion.api.util;

import org.apache.commons.lang3.RegExUtils;

public class StringUtil {
	
	public static String escapeTag(String source) {
		return RegExUtils.replaceAll(source, "<.*?>", "");
	}
}
