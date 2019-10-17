package com.example.conversion.api.util;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MergeUtilTest {
	
	@Test
	public void t1_mergeText() {
		
		final String sourceAlphabet = "AAaaBbb";
		final String sourceNumber = "0012";
		final String expectedMergedText = "A0A0a1a2Bbb";
		
		assertEquals(expectedMergedText, mergeText(sourceAlphabet, sourceNumber));
	}
	
	private String mergeText(String sourceAlphabet, String sourceNumber) {
		
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
