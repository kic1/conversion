package com.example.conversion.api.business;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class MergeText {
	
	public static String mergeText(String sourceAlphabet, String sourceNumber) {
		
		List<String> alphabets = Arrays.asList(sourceAlphabet.split(StringUtils.EMPTY));
		List<String> numbers   = Arrays.asList(sourceNumber.split(StringUtils.EMPTY));
		
        StringBuilder stringBuilder = new StringBuilder();
        int alphabetSize = alphabets.size();
		int numberSize   = numbers.size();
		int loopCount    = NumberUtils.max(alphabetSize, numberSize);
		
        for (int i = NumberUtils.INTEGER_ZERO; i < loopCount; i++) {
            if (i < alphabetSize) stringBuilder.append(alphabets.get(i));
            if (i <   numberSize) stringBuilder.append(numbers.get(i));
        }
        
        return stringBuilder.toString();
	}
}
