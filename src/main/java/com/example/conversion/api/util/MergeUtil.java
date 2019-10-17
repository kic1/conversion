package com.example.conversion.api.util;

import org.apache.commons.lang3.math.NumberUtils;

public class MergeUtil {
	
	public static String mergeText(String sourceAlphabet, String sourceNumber) {
		
		String[] alphabetArray = sourceAlphabet.split("");
		String[] numberArray   = sourceNumber.split("");
		
        StringBuilder stringBuilder = new StringBuilder();
        
        int loopCount = NumberUtils.max(alphabetArray.length, numberArray.length);
        for (int i = 0; i < loopCount; i++) {
            if (i < alphabetArray.length) stringBuilder.append(alphabetArray[i]);
            if (i <   numberArray.length) stringBuilder.append(numberArray  [i]);
        }
        
        return stringBuilder.toString();
	}
}
