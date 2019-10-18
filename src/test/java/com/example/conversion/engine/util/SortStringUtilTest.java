package com.example.conversion.engine.util;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortStringUtilTest {
	
	@Test
	public void t01_getAlphabeticalText() {
		
		final String sourceAlphabet = "AabABba";
		final String expectedAlphabeticalText = "AAaaBbb";
		
		assertEquals(expectedAlphabeticalText, SortStringUtil.getOrderedText(sourceAlphabet, new ComparatorAlphabet()));
	}
	
	@Test
	public void t02_getAlphabeticalText() {
		
		final String sourceNumber = "2918";
		final String expectedNumericalText = "1289";
		
		assertEquals(expectedNumericalText, SortStringUtil.getOrderedText(sourceNumber, new ComparatorNumber()));
	}
}
