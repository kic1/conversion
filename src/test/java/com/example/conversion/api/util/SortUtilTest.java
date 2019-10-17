package com.example.conversion.api.util;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortUtilTest {
	
	@Test
	public void t1_getAlphabeticalText() {
		
		final String sourceAlphabet = "AabABba";
		final String expectedAlphabeticalText = "AAaaBbb";
		
		assertEquals(expectedAlphabeticalText, SortUtil.getOrderedText(sourceAlphabet, SortUtil.ALPHABETICAL_ORDER));
	}
	
	@Test
	public void t2_getAlphabeticalText() {
		
		final String sourceNumber = "2918";
		final String expectedNumericalText = "1289";
		
		assertEquals(expectedNumericalText, SortUtil.getOrderedText(sourceNumber, SortUtil.NUMERICAL_ORDER));
	}
}
