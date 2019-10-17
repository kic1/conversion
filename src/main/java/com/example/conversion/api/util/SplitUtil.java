package com.example.conversion.api.util;

public class SplitUtil {
	
	public static String getQuotientText(String source, int splitUnitAmount) {
		return source.substring(0, getSplitIndex(source, splitUnitAmount));
	}
	
	public static String getRemainText(String source, int splitUnitAmount) {
		return source.substring(getSplitIndex(source, splitUnitAmount));
	}
	
	public static int getSplitIndex(String source, int splitUnitAmount) {
		int sourceLength = source.length();
		int remainder  = sourceLength % splitUnitAmount;
		int splitIndex = sourceLength - remainder;
		return splitIndex;
	}
}
