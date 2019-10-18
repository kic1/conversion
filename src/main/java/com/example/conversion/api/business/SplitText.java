package com.example.conversion.api.business;

import java.math.BigInteger;

import org.apache.commons.lang3.math.NumberUtils;

public class SplitText {
	
	public static String getQuotientText(String source, BigInteger splitUnitAmount) {
		
		int splitIndex = getSplitIndex(source, splitUnitAmount);
		return source.substring(NumberUtils.INTEGER_ZERO, splitIndex);
	}
	
	public static String getRemainText(String source, BigInteger splitUnitAmount) {
		
		int splitIndex = getSplitIndex(source, splitUnitAmount);
		return source.substring(splitIndex);
	}
	
	public static int getSplitIndex(String source, BigInteger splitUnitAmount) {
		
		BigInteger sourceLength = BigInteger.valueOf(source.length());
		BigInteger remainder    = sourceLength.mod(splitUnitAmount);
		BigInteger splitIndex   = sourceLength.subtract(remainder);
		
		return splitIndex.intValue();
	}
}
