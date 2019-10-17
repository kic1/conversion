package com.example.conversion.api.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortUtilTest {
	
	@Test
	public void t1_getAlphabeticalText() {
		
		final String sourceAlphabet = "AabABba";
		final String expectedAlphabeticalText = "AAaaBbb";
		
		assertEquals(expectedAlphabeticalText, getOrderedText(sourceAlphabet, ALPHABETICAL_ORDER));
	}
	
	@Test
	public void t2_getAlphabeticalText() {
		
		final String sourceNumber = "2918";
		final String expectedNumericalText = "1289";
		
		assertEquals(expectedNumericalText, getOrderedText(sourceNumber, NUMERICAL_ORDER));
	}
    
    private String getOrderedText(String source, Comparator<String> pattern){
    	
        String[] sortedArray = source.split("");
        Arrays.sort(sortedArray, pattern);
        
        return String.join("", sortedArray);
    }
    
    public Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
    	public int compare(String str1, String str2) {
    		int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
    		if (res == 0) {
    			res = str1.compareTo(str2);
    		}
    		return res;
    	}
    };
    
    public Comparator<String> NUMERICAL_ORDER = new Comparator<String>() {
    	public int compare(String str1, String str2) {
    		return Integer.parseInt(str1) - Integer.parseInt(str2);
    	}
    };
}
