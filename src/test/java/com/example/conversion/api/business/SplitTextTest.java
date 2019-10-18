package com.example.conversion.api.business;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.apache.commons.lang3.StringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SplitTextTest {
	
	private final String source = "A0A0a1a7BCZ";
	
	@Test
	public void t01_splitText() {		
		BigInteger splitUnitAmount = BigInteger.valueOf(3);
		assertEquals("A0A0a1a7B", getQuotientText(splitUnitAmount));
		assertEquals("CZ", getRemainText(splitUnitAmount));
	}
	
	@Test
	public void t02_splitText() {		
		BigInteger splitUnitAmount = BigInteger.valueOf(4);
		assertEquals("A0A0a1a7", getQuotientText(splitUnitAmount));
		assertEquals("BCZ", getRemainText(splitUnitAmount));
	}
	
	@Test
	public void t03_splitText() {		
		BigInteger splitUnitAmount = BigInteger.valueOf(1);
		assertEquals("A0A0a1a7BCZ", getQuotientText(splitUnitAmount));
		assertEquals(StringUtils.EMPTY, getRemainText(splitUnitAmount));
	}
	
	@Test
	public void t04_splitText() {		
		BigInteger splitUnitAmount = BigInteger.valueOf(5);
		assertEquals("A0A0a1a7BC", getQuotientText(splitUnitAmount));
		assertEquals("Z", getRemainText(splitUnitAmount));
	}
	
	private String getRemainText(BigInteger splitUnitAmount) {
		return SplitText.getRemainText(source, splitUnitAmount);
	}
	
	private String getQuotientText(BigInteger splitUnitAmount) {
		return SplitText.getQuotientText(source, splitUnitAmount);
	}
}
