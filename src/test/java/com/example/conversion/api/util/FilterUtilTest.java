package com.example.conversion.api.util;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FilterUtilTest {
	
	private final String source = "01A9a2Bz";
	
	@Test
	public void t1_filterOnlyAlphabet() {
		assertEquals("AaBz", FilterUtil.getOnlyAlphabet(source));
	}
	
	@Test
	public void t2_filterOnlyNumber() {
		assertEquals("0192", FilterUtil.getOnlyNumber(source));
	}
}
