package com.example.conversion.api.util;

public class FilterUtil {
	
	public static String getOnlyNumber(String source) {
		return source.replaceAll("[^0-9]", "");
	}
	
	public static String getOnlyAlphabet(String source) {
		return source.replaceAll("[^a-zA-Z]", "");
	}
}
