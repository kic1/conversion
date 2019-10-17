package com.example.conversion.api.util;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SplitUtilTest {
	
	final String source = "A0A0a1a7BCZ";
	
	@Test
	public void t1_splitText() {
		
		int splitUnitAmount = 3;
		assertEquals("A0A0a1a7B", getQuotientText(source, splitUnitAmount));
		assertEquals("CZ", getRemainText(source, splitUnitAmount));
	}
	
	@Test
	public void t2_splitText() {
		
		int splitUnitAmount = 4;		
		assertEquals("A0A0a1a7", getQuotientText(source, splitUnitAmount));
		assertEquals("BCZ", getRemainText(source, splitUnitAmount));
		
	}
	@Test
	public void t3_splitText() {
		
		int splitUnitAmount = 1;		
		assertEquals("A0A0a1a7BCZ", getQuotientText(source, splitUnitAmount));
		assertEquals("", getRemainText(source, splitUnitAmount));
	}
	
	@Test
	public void t4_splitText() {
		
		int splitUnitAmount = 5;		
		assertEquals("A0A0a1a7BC", getQuotientText(source, splitUnitAmount));
		assertEquals("Z", getRemainText(source, splitUnitAmount));
	}
	
	private String getQuotientText(String source, int splitUnitAmount) {
		return source.substring(0, getSplitIndex(source, splitUnitAmount));
	}
	
	private String getRemainText(String source, int splitUnitAmount) {
		return source.substring(getSplitIndex(source, splitUnitAmount));
	}
	
	private int getSplitIndex(String source, int splitUnitAmount) {
		int sourceLength = source.length();
		int remainder  = sourceLength % splitUnitAmount;
		int splitIndex = sourceLength - remainder;
		return splitIndex;
	}
}
