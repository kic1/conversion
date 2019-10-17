package com.example.conversion.api.util;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SplitUtilTest {
	
	private final String source = "A0A0a1a7BCZ";
	
	@Test
	public void t1_splitText() {		
		int splitUnitAmount = 3;
		assertEquals("A0A0a1a7B", getQuotientText(splitUnitAmount));
		assertEquals("CZ", getRemainText(splitUnitAmount));
	}
	
	@Test
	public void t2_splitText() {		
		int splitUnitAmount = 4;		
		assertEquals("A0A0a1a7", getQuotientText(splitUnitAmount));
		assertEquals("BCZ", getRemainText(splitUnitAmount));
	}
	
	@Test
	public void t3_splitText() {		
		int splitUnitAmount = 1;		
		assertEquals("A0A0a1a7BCZ", getQuotientText(splitUnitAmount));
		assertEquals("", getRemainText(splitUnitAmount));
	}
	
	@Test
	public void t4_splitText() {		
		int splitUnitAmount = 5;		
		assertEquals("A0A0a1a7BC", getQuotientText(splitUnitAmount));
		assertEquals("Z", getRemainText(splitUnitAmount));
	}
	
	private String getRemainText(int splitUnitAmount) {
		return SplitUtil.getRemainText(source, splitUnitAmount);
	}
	
	private String getQuotientText(int splitUnitAmount) {
		return SplitUtil.getQuotientText(source, splitUnitAmount);
	}
}
